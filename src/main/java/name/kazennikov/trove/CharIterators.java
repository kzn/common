package name.kazennikov.trove;

import gnu.trove.iterator.TCharIterator;

/**
 * Created with IntelliJ IDEA.
 * User: ant
 * Date: 05.08.12
 * Time: 21:36
 * To change this template use File | Settings | File Templates.
 */
public class CharIterators {
	
	/**
	 * Basic iterator for char sequence
	 * 
	 * @param seq source char sequence
	 * 
	 * @return iterator
	 */
    public static TPositionalCharIterator iterator(final CharSequence seq) {
        return new TPositionalCharIterator() {
            int pos;

            @Override
            public char next() {
                return seq.charAt(pos++);
            }

            @Override
            public boolean hasNext() {
                return pos < seq.length();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public int getPos() {
                return pos;
            }

            @Override
            public void setPos(int pos) {
                this.pos = pos;
            }
        };
    }
    
    /**
     * Return lowercase version of given iterator
     * 
     * @param it source iterator
     * 
     * @return lowercased iterator
     */
    public static TCharIterator lowerCase(final TCharIterator it) {
    	return new TCharIterator() {
			
			@Override
			public void remove() {
				it.remove();
			}
			
			@Override
			public boolean hasNext() {
				return it.hasNext();
			}
			
			@Override
			public char next() {
				return Character.toLowerCase(it.next());
			}
		};
    }
    
}
