package com.studiokaori.trackmoney.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studiokaori.trackmoney.item.Item;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class SaveLoadItems {

    public List<Item> loadSavedItems(List<Item> items, String fileName) throws IOException, NoSuchFileException {

        File file = new File(fileName);

        if (file.exists()) {

            // to close the file either way, use try resource. The caller will catch error.
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                String line = null;
                while ((line = br.readLine()) != null) {

                    Item item = mapToItem(line);
                    items.add(item);

                }

            }

        } else {

            throw new NoSuchFileException("File does not exist.");

        }


        return items;
    }


    public Item mapToItem(String json) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Item item = mapper.readValue(json, new TypeReference<Item>() {
        });

        return item;
    }

    public boolean saveItems(List<Item> items, String fileName) throws IOException {

        String json = createJsonString(items);

        File file = new File(fileName);
        if (!file.canWrite()) {

            file.setWritable(true);

        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        bufferedWriter.write(json);
        bufferedWriter.close();

        return true;
    }


    public String createJsonString(List<Item> items) throws JsonProcessingException {

        StringBuilder stringBuilder = new StringBuilder();

        ObjectMapper mapper = new ObjectMapper();


        for (Item item : items) {

            stringBuilder.append(mapper.writeValueAsString(item));
            stringBuilder.append(System.getProperty("line.separator"));

        }

        return stringBuilder.toString();
    }
}
