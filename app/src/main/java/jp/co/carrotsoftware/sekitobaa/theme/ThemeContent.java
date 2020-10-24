package jp.co.carrotsoftware.sekitobaa.theme;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ThemeContent {

    /**
     * An array of sample (Theme) items.
     */
    public static final List<ThemeItem> ITEMS = new ArrayList<ThemeItem>();

    /**
     * A map of sample (Theme) items, by ID.
     */
    public static final Map<String, ThemeItem> ITEM_MAP = new HashMap<String, ThemeItem>();

    private static final int COUNT = 25;

    static {
        try {
            JSONObject json = new JSONObject("{\"ID\":\"001\",\"Name\":\"アンドロイド\"}");
            String id   = json.getString("ID");
            String name = json.getString("Name");
        }
        catch (org.json.JSONException e) {

        }        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createThemeItem(i));
        }
    }

    private static void addItem(ThemeItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ThemeItem createThemeItem(int position) {
        return new ThemeItem(String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position),String.valueOf(position));
    }

    /**
     * A Theme item representing a piece of content.
     */
    public static class ThemeItem {
        public final String id;
        public final String name1;
        public final String title;
        public final String abstract1;
        public final String docs;
        public final String github;
        public final String group;
        public final String purpose;
        public final String status;
        public final String memo;
        public final String dependencies;
        public final String planed_start;
        public final String actual_start;
        public final String duration;
        public final String planed_finish;
        public final String actual_finish;

        public ThemeItem(String id,String name1,String title,String abstract1,String docs,String github,String group,String purpose,String status,String memo,String dependencies,String planed_start,String actual_start,String duration,String planed_finish,String actual_finish) {
            this.id = id;
            this.name1 = name1;
            this.title = title;
            this.abstract1 = abstract1;
            this.docs = docs;
            this.github = github;
            this.group = group;
            this.purpose = purpose;
            this.status = status;
            this.memo = memo;
            this.dependencies = dependencies;
            this.planed_start = planed_start;
            this.actual_start = actual_start;
            this.duration = duration;
            this.planed_finish = planed_finish;
            this.actual_finish = actual_finish;
        }
    }
}