package org.software.ysu.controller;

import org.software.ysu.pojo.*;
import org.software.ysu.service.Interface.IAssortService;
import org.software.ysu.service.Interface.IIntroService;
import org.software.ysu.service.Interface.ISubjectService;
import org.software.ysu.service.Interface.ITeamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Erisu
 * @date 2018/12/22 16:10
 * @Description TODO
 * @Version 1.0
 **/
@RequestMapping("achievement")
@RestController
public class achievementController {
    @Resource
    IIntroService introService;
    @Resource
    ISubjectService subjectService;
    @Resource
    ITeamService teamService;
    @Resource
    IAssortService assortService;
    @RequestMapping("getAchievements.do")
    public tableResponse getSubjects(Page page) {
        System.out.println("page="+page.toString());
         IntroductionExample introductionExample = new IntroductionExample();
        if (page.getContext() != ""){
            introductionExample.createCriteria().andIntroTitleLike("%" + page.getContext() + "%");
        }
        List<IntroductionWithBLOBs>intros=introService.getIntros(introductionExample);
        int tempMin=Math.min(intros.size(),page.getPage() * page.getLimit());
        //前台真正显示的数据
        List<IntroductionWithBLOBs>introPages=new ArrayList<>();
        for(int i=(page.getPage() - 1) * page.getLimit();i<tempMin;i++){
            introPages.add(intros.get(i));
        }
        tableResponse tableResponse=new tableResponse("0","",intros.size(),introPages);
        return tableResponse;
    }
    @RequestMapping("recentAchievements.do")
    public List<IntroductionWithBLOBs> getRecents() {
        IntroductionExample introductionExample = new IntroductionExample();
        introductionExample.setOrderByClause("'intro_createTime' DESC");
        List<IntroductionWithBLOBs>intros=introService.getIntros(introductionExample);
        //前台真正显示的数据
        List<IntroductionWithBLOBs>introPages=new ArrayList<>();
        int temp=Math.min(intros.size(),3);
        for(int i=0;i<temp;i++){
            introPages.add(intros.get(i));
        }
        return introPages;
    }
    @RequestMapping("singleAchievements.do")
    public Introduction getSingleAchievement(int introId){
        IntroductionWithBLOBs introduction=introService.getIntroById(introId);
        return introduction;
    }
    @RequestMapping("singleSubject.do")
    public Subject getSingleSubject(int introId){
        IntroductionWithBLOBs introduction=introService.getIntroById(introId);
        SubjectExample subjectExample=new SubjectExample();
        subjectExample.createCriteria().andSubjectIdEqualTo(introduction.getSubjectId());
        return subjectService.showSubjects(subjectExample).get(0);
    }
    @RequestMapping("teamInfo.do")
    public TeamWithBLOBs showTeam(){
        TeamWithBLOBs team=teamService.getTeam(new TeamExample()).get(0);
        return team;
    }
    @RequestMapping("assortInfo.do")
    public List<Assort> showAssorts(){
        AssortExample assortExample=new AssortExample();
        assortExample.createCriteria().andAssortParentidGreaterThan(0);
        List<Assort>assorts=assortService.showAssorts(assortExample);
        Random rand = new Random();
        List<Assort>realAssorts=new ArrayList<>();
        for(int i=0;i<5;i++){
            int temp = rand.nextInt(assorts.size());
            realAssorts.add(assorts.get(temp));
        }
        return realAssorts;
    }
}
