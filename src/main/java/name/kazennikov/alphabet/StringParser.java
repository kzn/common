package name.kazennikov.alphabet;

public interface StringParser<E> {
	public E parse(String s);
	public String serialize(E object);
	
	public static class Identity implements StringParser<String> {

		@Override
		public String parse(String s) {
			return s;
		}

		@Override
		public java.lang.String serialize(String object) {
			return object;
		}
	}

}
