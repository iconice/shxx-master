package com.sjht.school.football.service.football.student;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;

public interface GradeService {

    /**
     * 得到年级列表
     * @return
     */
    ObjectResponse getgradeList(String userId);

    /**
     * 得到用户选择的年级和没有选择的年级
     * @param userId
     * @return
     */
    BaseResponse getUserGradeList(String userId);
}
