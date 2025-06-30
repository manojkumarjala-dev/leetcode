class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int total = 0;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (int left = 0; left < n; left++) {
            Map<Character, Integer> vowelFreq = new HashMap<>();
            int consonants = 0;

            for (int right = left; right < n; right++) {
                char ch = word.charAt(right);

                if (vowels.contains(ch)) {
                    vowelFreq.put(ch, vowelFreq.getOrDefault(ch, 0) + 1);
                } else {
                    consonants++;
                }

                if (consonants > k) break;

                if (consonants == k && vowelFreq.size() == 5) {
                    total++;
                }
            }
        }

        return total;
    }
}