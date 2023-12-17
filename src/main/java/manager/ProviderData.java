package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User()
                .withEmail("vasya_pupkin@gmail.com")
                .withPassword("Vp12345$")});
        list.add(new Object[]{new User()
                .withEmail("joe_1@gmail.com")
                .withPassword("$Asdf1234")});
        list.add(new Object[]{new User()
                .withEmail("joe_2@gmail.com")
                .withPassword("$Asdf1235")});
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> userDTOCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/reg_dataset.csv"));
        String line = reader.readLine();
        while (line!=null) {
            String[] parts = line.split(",");
            list.add(new Object[]{new User()
                    .withName(parts[0])
                    .withLastName(parts[1])
                    .withEmail(parts[2])
                    .withPassword(parts[3])
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
}
