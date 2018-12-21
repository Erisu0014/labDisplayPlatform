package org.software.ysu.service.Interface;

import org.software.ysu.pojo.Photograph;
import org.software.ysu.pojo.PhotographExample;

import java.util.List;

public interface IPhotographService {
    public int addPhoto(Photograph photograph);
    public int modify(Photograph photograph);
    public List<Photograph> showPhotographs(PhotographExample photographExample);
}
