import java.util.*;

public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length)); // Sort by length

        Set<String> parentSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String path : folder) {
            boolean isSubfolder = false;
            int i = 1; // Start from index 1 to skip initial '/'

            while (i < path.length()) {
                int nextSlash = path.indexOf('/', i);
                if (nextSlash == -1) break;

                String prefix = path.substring(0, nextSlash);
                if (parentSet.contains(prefix)) {
                    isSubfolder = true;
                    break;
                }
                i = nextSlash + 1;
            }

            if (!isSubfolder) {
                parentSet.add(path);
                result.add(path);
            }
        }

        return result;
    }
}
