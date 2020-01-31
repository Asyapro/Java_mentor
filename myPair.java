public class myPair {
        String key;
        int value;

        myPair (String s, int v) {
            this.value = v;
            this.key = s;
        }
        public String key() { return key; }
        public int value() { return value; }
        public void set(myPair mp, String k) { this.key = k; }
        public void set(myPair mp, int v) { this.value = v; }
}
