package com.allerates.appforyou.json;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rikmen on 04.07.2018.
 */

public class MainTest extends AppCompatActivity {
    private static int current;
    private static class MyCustomExclusionStrategy implements ExclusionStrategy {

        public boolean shouldSkipClass(Class<?> arg0) {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes f) {
            return (f.getDeclaringClass() == Todo.class && f.getName().equals("changes"));
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            List<Todo> list = new ArrayList<Todo>();
            list.add(createTodo("Application model", "Flexible and extensible"));
            list.add(createTodo("DI", "@Inject as programming mode"));
            list.add(createTodo("OSGi", "Services"));
            list.add(createTodo("SWT", "Widgets"));
            list.add(createTodo("JFace", "Especially Viewers!"));
            list.add(createTodo("CSS Styling", "Style your application"));
            list.add(createTodo("Eclipse services", "Selection, model, Part"));
            list.add(createTodo("Renderer", "Different UI toolkit"));
            list.add(createTodo("Compatibility Layer", "Run Eclipse 3.x"));

            Gson gson = new GsonBuilder().setPrettyPrinting().setExclusionStrategies(new MyCustomExclusionStrategy()).create();
            Type type = new TypeToken<List<Todo>>() {}.getType();
            String json = gson.toJson(list, type);
            try {
                Files.write(Paths.get("android.resource://com.allerates.appforyou/raw/"), json.getBytes(), StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String content ="";
            try {
                content = new String(Files.readAllBytes(Paths.get("radar_search.json")));
            } catch (IOException e) {
                e.printStackTrace();
            }

        Toast.makeText(MainTest.this, content, Toast.LENGTH_LONG).show();
            System.out.println(content);
    }
    private static Todo createTodo(String summary, String description) {
        return new Todo(current++, summary, description, false, new Date());
    }
}
