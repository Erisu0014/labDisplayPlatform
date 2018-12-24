package org.software.ysu.service.achievements;

import org.software.ysu.dao.AssortMapper;
import org.software.ysu.pojo.Assort;
import org.software.ysu.pojo.AssortExample;
import org.software.ysu.service.Interface.IAssortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AssortServiceImpl implements IAssortService {
    @Resource
    AssortMapper assortMapper;

    @Override
    public List<Assort> showAssorts(AssortExample assortExample) {
        return assortMapper.selectByExample(assortExample);
    }
}
