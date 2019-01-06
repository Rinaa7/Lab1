package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.entity.Message;
import test.repository.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ChangesService implements Serializable {
        private static final Logger logger = LoggerFactory.getLogger(ChangesService.class);

        @Autowired
        private Category2Repository category2Repository;
        private Customer2Repository customer2Repository;
        private Manufacturer2Repository manufacturer2Repository;
        private Order2Repository order2Repository;
        private Product2Repository product2Repository;


        public List<Message> collectChange() {
            List<Message> messages = new CopyOnWriteArrayList<>();

            category2Repository.findAll().parallelStream()
                    .forEach(category2 -> {
                        category2.setRead(true);
                        category2Repository.save(category2);
                        try {
                            String value = new ObjectMapper().writeValueAsString(category2);
                            messages.add(new Message("category2", value, category2.getInput()));
                        } catch (JsonProcessingException e) {
                            logger.error("Error", e);
                        }
                    });

            customer2Repository.findAll().parallelStream()
                    .forEach(customer2 -> {
                        customer2.setRead(true);
                        customer2Repository.save(customer2);
                        try {
                            String value = new ObjectMapper().writeValueAsString(customer2);
                            messages.add(new Message("customer2", value, customer2.getInput()));
                        } catch (JsonProcessingException e) {
                            logger.error("Error", e);
                        }
                    });

            manufacturer2Repository.findAll().parallelStream()
                    .forEach(manufacturer2 -> {
                        manufacturer2.setRead(true);
                        manufacturer2Repository.save(manufacturer2);
                        try {
                            String value = new ObjectMapper().writeValueAsString(manufacturer2);
                            messages.add(new Message("manufacturer2", value, manufacturer2.getInput()));
                        } catch (JsonProcessingException e) {
                            logger.error("Error", e);
                        }
                    });

            order2Repository.findAll().parallelStream()
                    .forEach(order2 -> {
                        order2.setRead(true);
                        order2Repository.save(order2);
                        try {
                            String value = new ObjectMapper().writeValueAsString(order2);
                            messages.add(new Message("order2", value, order2.getInput()));
                        } catch (JsonProcessingException e) {
                            logger.error("Error", e);
                        }
                    });

            product2Repository.findAll().parallelStream()
                    .forEach(product2 -> {
                        product2.setRead(true);
                        product2Repository.save(product2);
                        try {
                            String value = new ObjectMapper().writeValueAsString(product2);
                            messages.add(new Message("product2", value, product2.getInput()));
                        } catch (JsonProcessingException e) {
                            logger.error("Error", e);
                        }
                    }
            );

            return messages;
        }

}