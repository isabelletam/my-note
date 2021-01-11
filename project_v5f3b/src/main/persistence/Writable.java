package persistence;

import org.json.JSONObject;

// THE CODE WAS BASED OFF OF Json serialization demo!
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
