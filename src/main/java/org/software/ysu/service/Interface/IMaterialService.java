package org.software.ysu.service.Interface;

import org.software.ysu.pojo.Material;
import org.software.ysu.pojo.MaterialExample;

import java.util.List;

public interface IMaterialService {
    public List<Material> showMaterials(MaterialExample materialExample);
    public List<Material> getMaterialsByAssortId(Integer assortId);
}
