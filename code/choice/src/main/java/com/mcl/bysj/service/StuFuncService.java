package com.mcl.bysj.service;

import com.mcl.bysj.entity.LessonChoice;
import com.mcl.bysj.entity.LessonInfo;

import java.util.List;

/**
 * 学生功能逻辑接口
 * Created by 明春霖 on 17/5/20.
 */
public interface StuFuncService
{
    List<LessonInfo> findOptionalLesson(LessonInfo lessonInfo);

    List<LessonInfo> findRequiredLesson(LessonInfo lessonInfo);

    LessonInfo findLessonById(String lessonId);

    LessonChoice findLessonChoiceById(LessonChoice lessonChoice);

    List<LessonChoice> findAllLessonChoice(LessonChoice lessonChoice);

    int addLessonChoice(LessonChoice lessonChoice);

    int updateChoseStu(LessonInfo lessonInfo);

    int deleteLessonChoice(LessonChoice lessonChoice);
}
