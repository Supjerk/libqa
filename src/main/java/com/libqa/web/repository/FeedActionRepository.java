package com.libqa.web.repository;

import com.libqa.application.enums.ActionType;
import com.libqa.application.enums.ThreadType;
import com.libqa.web.domain.FeedAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedActionRepository extends JpaRepository<FeedAction, Integer> {
    List<FeedAction> findByFeedActorIdAndUserIdAndIsCanceledFalse(Integer feedActorId, Integer userId);

    Integer countByFeedActorIdAndThreadTypeAndActionTypeAndIsCanceledFalse(
            Integer feedActorId, ThreadType threadType, ActionType actionType);
}
