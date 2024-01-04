package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.Movie;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    void 아이템_저장() throws Exception {
        // given
        Item item = new Book();

        // when
        Long itemId = itemService.saveItem(item);

        // then
        Assertions.assertThat(itemService.findOne(itemId)).isEqualTo(item);
    }

    @Test
    void 아이템_조회() throws Exception {
        // given
        Item item1 = new Book();
        Item item2 = new Movie();

        // when
        itemService.saveItem(item1);
        itemService.saveItem(item2);

        // then
        Assertions.assertThat(itemService.findItems()).containsOnly(item1, item2);
    }
}
