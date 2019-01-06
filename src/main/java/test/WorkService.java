package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.entity.Message;

import java.util.Comparator;
import java.util.List;
@Service
public class WorkService {
    @Autowired
    private ProducerComponent producerComponent;

    @Autowired
    private ChangesService changesService;

    @Autowired
    private ReplicationService replicationService;

    public void collectAndSendDBChange() {
        List<Message> dbChanges = changesService.collectChange();
        dbChanges.stream().sorted(Comparator.comparing(Message::getDateTime))
                .forEach(o -> producerComponent.send("Queue", o) );
    }
}
