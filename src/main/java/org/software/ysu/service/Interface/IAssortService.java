package org.software.ysu.service.Interface;

import org.software.ysu.pojo.Assort;
import org.software.ysu.pojo.AssortExample;

import java.util.List;

public interface IAssortService {
    public List<Assort> showAssorts(AssortExample assortExample);
}
