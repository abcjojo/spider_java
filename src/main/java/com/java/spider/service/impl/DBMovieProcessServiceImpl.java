package com.java.spider.service.impl;

import com.java.spider.entity.Page;
import com.java.spider.service.IProcessService;
import com.java.spider.util.HtmlUtil;
import com.java.spider.util.LoadPropertyUtil;
import com.java.spider.util.RegexUtil;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: learn_spider
 * @description: 豆瓣电影TOP250页面解析类
 * @author: Jojo.Lee
 * @create: 2020-03-20 10:30
 **/
@Component
public class DBMovieProcessServiceImpl implements IProcessService {

    public void process(Page page){
        String content = page.getContent();

        HtmlCleaner htmlCleaner = new HtmlCleaner();

        TagNode rootNode = htmlCleaner.clean(content);

        if (page.getUrl().startsWith("https://movie.douban.com/subject/")){
            //解析详情页的url
            System.out.println("开始解析详情页：");
            parseDetail(page,rootNode);
        }else{
            //解析列表页
            System.out.println("开始解析列表页：");
            //下一个列表页url
            String nextUrl = HtmlUtil.getAttributeByName(rootNode,LoadPropertyUtil.getDouBan("nextUrl"),"href");
            if (nextUrl != null) {
                nextUrl = "https://movie.douban.com/top250" + nextUrl;
                //为什么加到Page里面  这里感觉有问题！！！！！！！
                page.addUrlList(nextUrl);
            }

            //获取详情页的url
            try {
                Object[] evaluateXPath = rootNode.evaluateXPath(LoadPropertyUtil.getDouBan("eachDetailUrl"));
                if (evaluateXPath.length>0){
                    for (Object object : evaluateXPath){
                        TagNode node = (TagNode) object;
                        //String detailUrl = HtmlUtil.getAttributeByName(node,LoadPropertyUtil.getDouBan("eachDetailUrl"),"href");
                        String detailUrl = node.getAttributeByName("href");
                        System.out.println("列表页URL： "+detailUrl);
                        //将解析出来的引述与详情页url绑在一起
                        String parseQuote = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getDouBan("parseQuote"), LoadPropertyUtil.getDouBan("commonRegex"));
                        detailUrl = detailUrl + "@" + parseQuote;
                        page.addUrlList(detailUrl);
                        //System.out.println("detailUrl:"+detailUrl);
                    }
                }
            } catch (XPatherException e) {
                e.printStackTrace();
            }

        }
    }

    //解析视屏详情页
    public void parseDetail(Page page, TagNode rootNode){

        //主要信息
        String info = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getDouBan("parseInfo"),LoadPropertyUtil.getDouBan("commonRegex"));
        System.out.println(info);

        String[] lines = {"导演:","编剧:","主演:","类型:","制片国家/地区:","语言:","上映日期:","片长:","又名:"};
        String[] infos = info.split("\n");
        for (String i : lines){
            String tempRegex = i + ".*";
            for (String j : infos){
                if (Pattern.matches(tempRegex, j.trim())){
                    String[] tem = j.split(i);
                    addparse(i,tem[1],page);
                    System.out.println(i+"   "+tem[1]);
                    break;
                }
            }
        }

        //电影排名
        String no = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getDouBan("parseNo"), LoadPropertyUtil.getDouBan("noRegex"));
        int intNo = Integer.parseInt(no);
        page.setNo(intNo);

        //评论人数
        String number = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getDouBan("parseNumber"), LoadPropertyUtil.getDouBan("numberRegex"));
        int temp = Integer.parseInt(number);
        page.setNumber(temp);

        //电影评分
        String score = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getDouBan("parseScore"),LoadPropertyUtil.getDouBan("numberRegex"));
        double intScore = Double.parseDouble(score);
        page.setScore(intScore);

        //电影名
        String name = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getDouBan("parseName"),LoadPropertyUtil.getDouBan("nameRegex"));
        page.setName(name);

        //获取电影id
        Pattern pattern = Pattern.compile(LoadPropertyUtil.getDouBan("movieIdRegex"));
        String url = page.getUrl();
        String videoId = RegexUtil.getPageInfoByRegex(url,pattern,1);
        page.setVideoId("DouBan_"+videoId);

        //内容简介
        String introduction = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getDouBan("parseIntroduction"),LoadPropertyUtil.getDouBan("commonRegex"));
        //page.setIntroduction(introduction);

        //IMDb播放链接
//        String IMDbUrl = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getDouBan("parseIMDbUrl"),LoadPropertyUtil.getDouBan("commonRegex"));
//        String IMDbUrl1 = rootNode.getAttributeByName("href");
//        page.setIMDbUrl(IMDbUrl);

    }

    public void addparse(String match, String date, Page page){
        //String[] lines = {"导演:","编剧:","主演:","类型:","制片国家/地区:","语言:","上映日期:","片长:","又名:"};
        if (match.matches("导演:")){
            page.setDirector(date);
        }else if (match.matches("编剧:")){
            String[] temp = date.split("/");
            String sb = temp[0];
            page.setScriptwriter(sb);
        }else if (match.matches("主演:")){
            String[] temp = date.split("/");
            String sb = temp[0]+"/"+temp[1];
            page.setProtagonists(sb);
        }else if (match.matches("类型:")){
            String[] temp = date.split("/");
            for (int i = 0; i < temp.length; i++){
                if (i == 0)
                    page.setType1(temp[0]);
                if (i == 1)
                    page.setType2(temp[1]);
                if (i == 2)
                    page.setType3(temp[2]);
            }
        }else if (match.matches("制片国家/地区:")){
            String[] temp = date.split("/");
            String sb = temp[0];
            page.setCountry(sb);
        }else if (match.matches("语言:")){
            String[] temp = date.split("/");
            String sb = temp[0];
            page.setLanguage(sb);
        }else if (match.matches("上映日期:")){
            String[] temp = date.split("/");
            String sb = temp[0];
            String[] time = sb.split("-");
            String year = time[0].trim();// 2008-06-27(美国)
            Pattern p = Pattern.compile("[^0-9]");
            Matcher matcher = p.matcher(year);
            String value = matcher.replaceAll("").trim();
            page.setYear(Integer.parseInt(value));//56146
            page.setReleaseDate(sb);
        }else if (match.matches("片长:")){
            String[] temp = date.split("/");
            String sb = temp[0];
            Pattern p = Pattern.compile("[^0-9]");
            Matcher matcher = p.matcher(sb);
            String value = matcher.replaceAll("").trim();
//            int i = 0;
//            while (matcher.find()) {
//                value = value + matcher.group(i);
//            }
            Integer va = Integer.parseInt(value);
            page.setMins(va);
        }else if (match.matches("又名:")){
            String[] temp = date.split("/");
            String sb = temp[0];
            page.setAlternateName(sb);
        }

    }
}
