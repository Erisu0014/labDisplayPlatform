package org.software.ysu.controller;

import org.software.ysu.pojo.*;
import org.software.ysu.service.Interface.IAssortService;
import org.software.ysu.service.Interface.IMaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("share")
public class shareController {
    @Resource
    IMaterialService materialService;
    @Resource
    IAssortService assortService;

    @RequestMapping("getAssorts.do")
    public List<Assort> getAssorts(){
        //查询assort表
        List<Assort> assorts = assortService.showAssorts(new AssortExample());
        //将material表中元素加入二级类链表
        for (Assort assort:assorts){
            if (assort.getAssortParentid()!=0){
                assort.setMaterialList(materialService.getMaterialsByAssortId(assort.getId()));
            }
        }
        //查询一级类
        List<Assort> assortsMaterials = new ArrayList<>();
        for (Assort assort:assorts){
            if (assort.getAssortParentid()==0){
                assort.setAssortList(new ArrayList<Assort>());
                assortsMaterials.add(assort);
            }
        }

        for (Assort assort1:assortsMaterials){
            for (Assort assort2:assorts){
                if (assort2.getAssortParentid()==assort1.getId()){
                    assort1.getAssortList().add(assort2);
                }
            }
        }

        return assortsMaterials;
    }

    @RequestMapping("getMoreMaterials.do")
    public  List<Material> getMoreMaterials(String assortId){
        int ID = Integer.parseInt(assortId);
        System.out.println(ID);
        MaterialExample materialExample = new MaterialExample();
        materialExample.createCriteria().andAssortIdEqualTo(ID);
        List<Material> materials = materialService.showMaterials(materialExample);
        return materials;
    }


}
