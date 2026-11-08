class TimeMap {

    class TimeStampedValue {
        int timestamp;
        String value;

        TimeStampedValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, ArrayList<TimeStampedValue>> entriesByKey;

    public TimeMap() {
        entriesByKey = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        entriesByKey.putIfAbsent(key, new ArrayList<>());

        entriesByKey.get(key).add(
            new TimeStampedValue(timestamp, value)
        );
    }

    public String get(String key, int timestamp) {

        if (!entriesByKey.containsKey(key)) {
            return "";
        }

        ArrayList<TimeStampedValue> list = entriesByKey.get(key);

        int left = 0;
        int right = list.size() - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                ans = mid;
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return ans == -1 ? "" : list.get(ans).value;
    }
}
