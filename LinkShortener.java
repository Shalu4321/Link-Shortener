import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener {
   private Map<String, String> shortToOriginal = new HashMap();
   private Map<String, String> originalToShort = new HashMap();
   private Random random = new Random();
   private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
   private static final int SHORT_URL_LENGTH = 6;

   public LinkShortener() {
   }

   public String shorten(String originalUrl) {
      if (this.originalToShort.containsKey(originalUrl)) {
         return (String)this.originalToShort.get(originalUrl);
      } else {
         String shortUrl = this.generateShortUrl();
         this.shortToOriginal.put(shortUrl, originalUrl);
         this.originalToShort.put(originalUrl, shortUrl);
         return shortUrl;
      }
   }

   public String getOriginalUrl(String shortUrl) {
      return (String)this.shortToOriginal.get(shortUrl);
   }

   private String generateShortUrl() {
      StringBuilder sb = new StringBuilder();

      for(int i = 0; i < 6; ++i) {
         int index = this.random.nextInt("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".length());
         sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(index));
      }

      return sb.toString();
   }

   public static void main(String[] args) {
      LinkShortener linkShortener = new LinkShortener();
      String originalUrl = "https://www.google.com";
      String shortUrl = linkShortener.shorten(originalUrl);
      System.out.println("Shortened URL: " + shortUrl);
      System.out.println("Original URL: " + linkShortener.getOriginalUrl(shortUrl));
   }
}
