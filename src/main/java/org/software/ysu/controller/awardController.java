package org.software.ysu.controller;

import com.alibaba.fastjson.JSON;
import org.software.ysu.pojo.*;
import org.software.ysu.service.Interface.IPhotographService;
import org.software.ysu.service.Interface.ISubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("award")
public class awardController {

    @Resource
    ISubjectService subjectService;
    @Resource
    IPhotographService photographService;

    @RequestMapping("getPhotos.do")
    @ResponseBody
    public List<PhotoSubject> getPhotos(){
        List<Photograph>photographs=photographService.showPhotographs(new PhotographExample());
        //对photoSubjects赋值
        List<PhotoSubject>photoSubjects=new ArrayList<>();
        for(Photograph photograph:photographs){
            PhotoSubject photoSubject=new PhotoSubject();
            photoSubject.setPhotograph(photograph);
            //查找项目名
            SubjectExample subjectExample=new SubjectExample();
            subjectExample.createCriteria().andSubjectIdEqualTo(photograph.getSubjectId());
            Subject subject=subjectService.showSubjects(subjectExample).get(0);

            photoSubject.setSubjectName(subject.getSubjectName());
            photoSubject.setSubjectStudents(subject.getSubjectStudent());
            photoSubject.setSubjectTeacher(subject.getSubjectTeacher());
            photoSubjects.add(photoSubject);
        }
        return photoSubjects;
    }
}
