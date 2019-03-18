package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemParser {

    public List<Item> parseItemList(String valueToParse) {
        List<Item> nuList = new ArrayList<Item>();

        String[] split1 = valueToParse.toLowerCase().split("##");
        for (int i = 0; i < split1.length; i++) {
            try {
                nuList.add(parseSingleItem(split1[i]));
            } catch (ItemParseException e) {
                e.printStackTrace();
            }


        }
        return nuList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String[] splitter = singleItem.toLowerCase().split("[;#]");
        try {
            for (int i = 0; i < splitter.length; i++) {
                splitter[i] = splitter[i].split("[:@^*%]")[1];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ItemParseException();
        }

        Item item = new Item(splitter[0], Double.valueOf(splitter[1]), splitter[2], splitter[3]);

        return item;
    }
}
