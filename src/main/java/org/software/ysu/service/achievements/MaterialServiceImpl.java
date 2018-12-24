package org.software.ysu.service.achievements;

import org.software.ysu.dao.MaterialMapper;
import org.software.ysu.pojo.Material;
import org.software.ysu.pojo.MaterialExample;
import org.software.ysu.service.Interface.IMaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialServiceImpl implements IMaterialService {

    @Resource
    MaterialMapper materialMapper;

    @Override
    public List<Material> showMaterials(MaterialExample materialExample) {
        return materialMapper.selectByExampleWithBLOBs(materialExample);
    }

    @Override
    public List<Material> getMaterialsByAssortId(Integer assortId) {
        MaterialExample materialExample = new MaterialExample();
        materialExample.createCriteria().andAssortIdEqualTo(assortId);
        return materialMapper.selectByExampleWithBLOBs(materialExample);
    }
}
