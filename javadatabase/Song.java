class Song{

	//instance variables
	private String title;
	private String artist;
	private int length; //in seconds
	private String[] tags;
	//static varaible
	private static int numSongs;

	//constructors
	public Song(String t){
		this(t,"",0,new String[0]);
	}
	public Song(String t, String a){
		this(t,a,0,new String[0]);
	}
	public Song(String t, String a, int l){
		this(t,a,l,new String[0]);
	}
	public Song(String t, String a, int l, String[] g){
		setTitle(t);
		setArtist(a);
		setLength(l);

		tags = g;

		numSongs++;
	}
	public Song(String t, int l){
		this(t,"",l,new String[0]);
	}
	public Song(String t, int l, String[] g){
		this(t,"",l,g);
	}
	public Song(String t, String[] g){
		this(t,"",0,g);
	}

	//getters
	public String getTitle(){
		return title;
	}
	public String getArtist(){
		return artist;
	}
	public int getLength(){
		return length;
	}
	//converts length into mm:ss for readability
	public String getTime(){
		int minutes = 0;
		int seconds = length;
		String time;
		
		while(true){
			if(seconds / 60.0 >= 1){
				minutes++;
				seconds -= 60;
			}
			else{
				time = "" + minutes + ":";
				if(seconds <= 9){
					time = time + "0" + seconds;
				}
				else{
					time = time + seconds;
				}
				return time;
			}
		}		
	}
	public String[] getTags(){
		return tags;
	}
	public static int getNumSongs(){
		return numSongs;
	}
	
	
	//setters
	public void setTitle(String t){
		title = t;
	}
	public void setArtist(String a){
		artist = a;
	}
	public void setLength(int l){
		length = l;
	}
	
	public void addTag(String tag){
		String[] temp = new String[tags.length + 1];
	 	for(int i = 0; i < tags.length; i++){
			temp[i] = tags[i];
		}
		temp[temp.length-1] = tag;
		tags = temp;
	}
	//public void removeTag(String tag){
		
	//}


	//other methods
	public String toString(){
		String text = title + "|" + artist + "|" + length + "|";
		for(int i = 0; i < tags.length; i++){
			text = text + tags[i] + ",";
		}
		return text;
	}

	public String toDisplay(){
		String display = title + ": By " + artist + "|" + getTime() + "| ";
		String spaceTags = "";
		if(tags.length > 0){
			for(int i = 0; i < tags.length; i++){
				spaceTags = spaceTags + tags[i] + ",";
			}
			spaceTags = spaceTags.substring(0,spaceTags.length() -1);
		}
		//add spacing for tags once you know how big the display is, something like:
		//I think technicaly you could manualy measure the pixels off each charecter and find the exact pixel count that way, but I don't have nearly enough time for that so i'm just changing the plan
		/**
		
		int spaces = ((450 - 32) - (display.length() * 8 + spaceTags.length() * 8)) / 9;
		System.out.println(spaces);
		for(int i = 0; i < spaces; i++){
			display = display + "<&nbsp;";
		}

		//*/
		display = display + spaceTags;
		return display;
	}

	public int compareTitle(Song s){
		return getTitle().compareToIgnoreCase(s.getTitle());
	}
	public int compareArtist(Song s){
		return getArtist().compareToIgnoreCase(s.getArtist());
	}
	public int compareLength(Song s){
		return getLength() - s.getLength();
	}

	public boolean equals(Song s){
		boolean temp = true;

		if(!(getTitle().equals(s.getTitle()))){
			temp = false;
		}
		if(!(getArtist().equals(s.getArtist()))){
			temp = false;
		}
		/**
		if(!(getLength() == s.getLength())){
			temp = false;
		}
		
		String[] array1 = getTags();
		String[] array2 = s.getTags();
		if(array1.length == array2.length){
			for(int i = 0; i < array1.length;i++){
				if(!(array1[i].equals(array2[i]))){
					temp = false;
				}
			}
		}
		//*/
		return temp;
	}
	
	
}
