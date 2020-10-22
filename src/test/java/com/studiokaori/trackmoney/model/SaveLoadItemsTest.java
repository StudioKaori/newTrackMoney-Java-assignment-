package com.studiokaori.trackmoney.model;

import com.studiokaori.trackmoney.item.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaveLoadItemsTest {
    String savedItemFileName = "savedItems.dat";
    List<Item> items = new ArrayList<>();


    @Test
    void loadSavedItemsSize() throws IOException {
        items = new SaveLoadItems().loadSavedItems(items, savedItemFileName);

        int expected = 12;
        int result = items.size();

        assertEquals(expected, result);
    }

    @Test
    void loadSavedItemsException() {

        Assertions.assertThrows(IOException.class, () -> {
            items = new SaveLoadItems().loadSavedItems(items, "invalid file path");
        });
    }

}