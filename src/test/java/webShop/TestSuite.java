package webShop;

 import org.junit.runner.RunWith;
 import org.junit.runners.Suite;
 
 @RunWith(Suite.class)
 @Suite.SuiteClasses({
	 Produkter.class,
	 Latest_Blog_Post.class,
	 Produktsidor.class,
	 ProductCategory.class,
	 Search.class,
	 AddToCart.class,
	 Checkout.class,})
 public class TestSuite {}