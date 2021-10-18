package calculator;

public class StringCalculator {
	public int count ;
	//Custom exception for -VE number
	public class NegativeNumberException extends Exception{
		public  NegativeNumberException(String msg) {
			super(msg);
		}

		}

	
	public static int Add(String s) throws NegativeNumberException {
		
		
		//if Empty String
		if(s.length()==0)
			return 0;
		
		//if a digit is passed
		else if(s.length()==1)
			return Integer.parseInt(s);
		
		// Delimeter is "," and ";"
		else if(s.contains(",")||s.contains(";")) {
			count=0;
			int sum = 0;
			
			s=s.replaceAll("\n", "");
			s=s.replaceAll(";", ",");
			
			int i = s.indexOf(",");
			s = s.substring(--i);
			String[] numStr = s.split(",");
				
			for (String str : numStr) 
				{
				
				//System.out.println("sf"+str);
					
				if(str.length()>0){
					if(Integer.parseInt(str)>1000)						// Ignoring Number greator than 1000
						i=0;
					
					
					else if(Integer.parseInt(str)<0)
						 throw new NegativeNumberException("negative number not allowed");  // Exception handling
						
					
					else
						i=Integer.parseInt(str);
					sum = sum +i ;
					count++;
					
				
				}
					
				
				
				}
			//System.out.println(sum);
			return sum ;
		}
		
		// delimeter given in square bracket with any length
		else if(s.contains("[")) {
			
		
		
			int index=0;
			int sum = 0;
			int i=0,j =0 ;
			count = 0;
			s=s.replaceAll("\n", "");
			
			//handaling metaCharactors
			
			s= s.replaceAll("\\*", "#");
			s= s.replaceAll("\\+", "#");
			s= s.replaceAll("\\^", "#");
			
			
			
			
			
			char[ ] c = s.toCharArray();
			for (int k = 0; k < s.length(); k++) {
				
			
				if(c[k]=='[')
					i =k;
				if(c[k]==']') {
					j=k;
					index = k+1;
				}
					
			}
			
			String delimeter= (String) s.subSequence(i+1, j);
			
			s = s.substring(index);
			s=s.trim();
			
			String[] numStr = s.split(delimeter); 
			for (String str : numStr) 
				{
				//System.out.println(str);
				
				
					if(Integer.parseInt(str)>1000)
						i=0;
					else if(Integer.parseInt(str)<0)
					 throw new NegativeNumberException("negative number not allowed");
					
					else
						i=Integer.parseInt(str);
					sum = sum +i ;
					count++;
					}
			//System.out.println(sum);
			return sum ;
			}
		
		else
			return 0;
		
	}
			
	public static int GetCalledCount() {
	return count;	
	}
			}

