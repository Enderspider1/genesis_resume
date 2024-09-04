import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.*;
import java.util.Arrays;
//import java.awt.BoxLayout;
import java.io.*;
import javax.swing.*;

//implements ActionListener
class Display extends JFrame implements ActionListener {
	//instance variables
	private final int windowWidth = 700;
	private final int windowHeight = 400;
	
	//right panel
	private JPanel rightPNL;
	private final JButton addSongBTN;
	private final JLabel title1LBL;
	private JTextField title1FLD;
	private final JLabel artist1LBL;
	private JTextField artist1FLD;
	private final JLabel lengthLBL;
	private JTextField lengthFLD;
	private final JLabel tagsLBL;
	private JTextField tagsFLD;
	
	private JButton removeSongBTN;
	private JLabel title2LBL;
	private JTextField title2FLD;
	private JLabel artist2LBL;
	private JTextField artist2FLD;
	
	//middle panel
	private Song[] library = new Song[0];
	private JPanel middlePNL;
	private JLabel textLibraryLBL;
	private JLabel textDisplayLBL;

	//left panel
	private JPanel leftPNL;
	private JLabel searchLBL;
	private JTextField searchFLD;
	private JLabel sortLBL;
	private JButton titleSortBTN;
	private JButton artistSortBTN;
	private JButton lengthSortBTN;

	



	public Display(){
		readLibrary();
		//Song[] library = new Song[0];
		//window
		setBounds(0,0,windowWidth,windowHeight);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//right panel
		rightPNL = new JPanel();
		rightPNL.setLayout(new BoxLayout(rightPNL, BoxLayout.PAGE_AXIS));
		rightPNL.setBackground(Color.gray);
		rightPNL.setBounds(windowWidth - 125,0,125,windowHeight);
    this.add(rightPNL);

		addSongBTN = new JButton("<html>ADD SONG<html>");
		//addSongLBL.setBounds(0,0,200,50);
		addSongBTN.addActionListener(this);
		rightPNL.add(addSongBTN);
		//addSongLBL.setAlignmentY(Component.BOTTOM_ALIGNMENT);

		title1LBL = new JLabel("<html>Title<html>", SwingConstants.CENTER);
		title1LBL.setForeground(Color.black);
		//title1LBL.setBounds(0,0,200,50);
		rightPNL.add(title1LBL);

		title1FLD = new JTextField();
		//title1FLD.setBounds(500,0,150,25);
		//title1FLD.setHeight(25);
		rightPNL.add(title1FLD);
		//this.add(title1FLD);
		
		artist1LBL = new JLabel("<html>Artist<html>", SwingConstants.CENTER);
		artist1LBL.setForeground(Color.black);
		rightPNL.add(artist1LBL);

		artist1FLD = new JTextField();
		rightPNL.add(artist1FLD);

		lengthLBL = new JLabel("<html>Length<html>", SwingConstants.CENTER);
		lengthLBL.setForeground(Color.black);
		rightPNL.add(lengthLBL);

		lengthFLD = new JTextField();
		rightPNL.add(lengthFLD);

		tagsLBL = new JLabel("<html>Tags<html>", SwingConstants.CENTER);
		tagsLBL.setForeground(Color.black);
		rightPNL.add(tagsLBL);

		tagsFLD = new JTextField();
		rightPNL.add(tagsFLD);

		//removing songs
		removeSongBTN = new JButton("<html>DEL SONG<html>");
		removeSongBTN.addActionListener(this);
		rightPNL.add(removeSongBTN);

		title2LBL = new JLabel("<html>Title<html>", SwingConstants.CENTER);
		title2LBL.setForeground(Color.black);
		rightPNL.add(title2LBL);

		title2FLD = new JTextField();
		rightPNL.add(title2FLD);
		
		artist2LBL = new JLabel("<html>Artist<html>", SwingConstants.CENTER);
		artist2LBL.setForeground(Color.black);
		rightPNL.add(artist2LBL);

		artist2FLD = new JTextField();
		rightPNL.add(artist2FLD);
		
		

		
		//middle panel
		middlePNL = new JPanel();
		middlePNL.setLayout(new BoxLayout(middlePNL, BoxLayout.PAGE_AXIS));
		middlePNL.setBackground(Color.lightGray);
		middlePNL.setBounds(windowWidth - 575,0,450,windowHeight);
    this.add(middlePNL);

		textLibraryLBL = new JLabel("<html>Library<html>", SwingConstants.CENTER);
		textLibraryLBL.setForeground(Color.black);
		//textLibraryLBL.setBackground(Color.darkGray);
		//textLibraryLBL.setOpaque(true);
		textLibraryLBL.setFont(new Font("Courier", Font.PLAIN, 18));
		middlePNL.add(textLibraryLBL);

		textDisplayLBL = new JLabel();
		textDisplayLBL.setFont(new Font("Courier", Font.BOLD, 13));
		showLibrary();
		textDisplayLBL.setForeground(Color.black);
		middlePNL.add(textDisplayLBL);


		//left panel
		leftPNL = new JPanel();
		leftPNL.setLayout(new BoxLayout(leftPNL, BoxLayout.PAGE_AXIS));
		leftPNL.setBackground(Color.gray);
		leftPNL.setBounds(0,0,125,windowHeight);
    this.add(leftPNL);
		
		sortLBL = new JLabel("<html>Sort<html>",SwingConstants.CENTER);
		sortLBL.setForeground(Color.black);
		//sortLBL.setFont(new Font("Courier", Font.PLAIN, 18));
		leftPNL.add(sortLBL);

		titleSortBTN = new JButton("<html>Title<html>");
		titleSortBTN.addActionListener(this);
		leftPNL.add(titleSortBTN);

		artistSortBTN = new JButton("<html>Artist<html>");
		artistSortBTN.addActionListener(this);
		leftPNL.add(artistSortBTN);

		lengthSortBTN = new JButton("<html>Length<html>");
		lengthSortBTN.addActionListener(this);
		leftPNL.add(lengthSortBTN);		

		searchLBL = new JLabel("<html>Search<html>",SwingConstants.CENTER);
		searchLBL.setForeground(Color.black);
		leftPNL.add(searchLBL);		

		searchFLD = new JTextField();
		searchFLD.addActionListener(this);
		leftPNL.add(searchFLD);
		
																		
		
		setVisible(true);
	}

	@Override
 public void actionPerformed(ActionEvent e) {
	 if (e.getSource() == addSongBTN){
		library = new Song[0];
		readLibrary();
		 
		 addSong(new Song(title1FLD.getText(),artist1FLD.getText(),Integer.parseInt(lengthFLD.getText()),inputTags()));
		//can cause errors in console with bad input but doesnt stop program
		 
		updateLibrary();
		showLibrary();
	 
	 title1FLD.setText("");
	 artist1FLD.setText("");
	 lengthFLD.setText("");
	 tagsFLD.setText("");
	 }

		else if(e.getSource() == removeSongBTN){
			library = new Song[0];
			readLibrary();
			removeSong(new Song(title2FLD.getText(),artist2FLD.getText()));
			//can cause errors in console with bad input but doesnt stop program
			updateLibrary();
			showLibrary();

			title2FLD.setText("");
	 		artist2FLD.setText("");
		}

	 else if (e.getSource() == titleSortBTN){
		 sortTitle();
		 //updateLibrary();
		 showLibrary();
		 //System.out.println(Arrays.toString(library));
	 }

	 else if (e.getSource() == artistSortBTN){
		 sortArtist();
		 //updateLibrary();
		 showLibrary();
	 }

	 else if (e.getSource() == lengthSortBTN){
		 sortLength();
		 //updateLibrary();
		 showLibrary();
	 }

	 else if(e.getSource() == searchFLD){
		 library = new Song[0];
		 readLibrary();
		 searchMethod(searchFLD.getText());
		 showLibrary();
	 }
 }

	private String[] inputTags(){
		String all = tagsFLD.getText();
		int start = 0;
		int end = 0;
		int comaCounter = 0;

		for(int i = 0; i < all.length(); i++){
			if(all.charAt(i) == ','){
				comaCounter++;
			}
		}
		String[] tempTags = new String[comaCounter + 1];
		comaCounter = 0;
		for(int i = 0; i < all.length(); i++){
			if(all.charAt(i) == ','){
				end = i;
				tempTags[comaCounter] = all.substring(start,end);
				comaCounter++;
				start = i+1;
			}
		}
		if(all.length() > 0){
			tempTags[comaCounter] = all.substring(start);
			return tempTags;
		}
		return new String[0];
	}

	private void addSong(Song s){
		Song[] temp = new Song[library.length + 1];
	 	for(int i = 0; i < library.length; i++){
			temp[i] = library[i];
		}
		temp[temp.length-1] = s;
		library = temp;
		//updateLibrary();
	}

	private void removeSong(Song s){
	//	System.out.println("Remove song run");
		Song[] temp = new Song[library.length - 1];
		int counter = 0;
	 	for(int i = 0; i < library.length; i++){
			//System.out.println(Arrays.toString(library) + i + "crying fr fr");
			if(!(library[i].equals(s))){
				//System.out.println(Arrays.toString(library) + i);
				temp[counter] = library[i];
				counter++;
				
			}
		}
		library = temp;
	}

	private void updateLibrary(){
		try{
			FileWriter fw = new FileWriter("Stored.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println(library.length);
			for(int i = 0; i < library.length;i++){
				pw.println(library[i]);
			}
			pw.close();
		}
		catch(IOException e){
			System.out.println("Printing error: " + e);
		}
	}
	//gets values stored in text file into library array
	private void readLibrary(){
		try{
			FileReader fr = new FileReader("Stored.txt");
			BufferedReader br = new BufferedReader(fr);
			Song[] temp = new Song[Integer.parseInt(br.readLine())];
			String whole = "";
			
			String titleT;
			String artistT;
			int lengthT;
			String[] tagsT = new String[0];
			String[] tagsT2 = new String[0];
			int start;
			int end;
			int counter;
			//goes through each line off text fiel
			for(int i = 0; i < temp.length; i++){
				whole = br.readLine();
				titleT = "";
				artistT = "";
				lengthT = 0;
				tagsT = new String[0];
				tagsT2 = new String[0];
				start = 0;
				end = 0;
				counter = 0;
				//goes thrrough each part of each line to break into Song components
				for(int j = 0; j < whole.length(); j++){
					//title
					if(counter == 0 && whole.charAt(j) == '|'){
						counter++;
						end = j;
						titleT = whole.substring(start,end);
						start = j+1;
					}
						//artist
					else if(counter == 1 && whole.charAt(j) == '|'){
						counter++;
						end = j;
						artistT = whole.substring(start,end);
						start = j+1;
					}
						//length
					else if(counter == 2 && whole.charAt(j) == '|'){
						counter++;
						end = j;
						lengthT = Integer.parseInt(whole.substring(start,end));
						start = j+1;
					}
					//tags :(
					else if(counter >= 3 && whole.charAt(j) == ','){
						end = j;
						tagsT2 = new String[tagsT.length + 1];
						for(int p = 0; p < tagsT.length; p++){
							tagsT2[p] = tagsT[p];
						}
						tagsT2[tagsT2.length -1] = whole.substring(start,end);
						tagsT = tagsT2;
						start = j+1;
					}
				}
				addSong(new Song(titleT,artistT,lengthT,tagsT));
			}
		}
		catch(IOException e){
			System.out.println("Reading error: " + e);
		}
	}

	//learned how to break lines frrom stack overflow (https://stackoverflow.com/questions/1090098/newline-in-jlabel)
	private void showLibrary(){
		String shown = "<html>___________________________________________________________________________<br/>";
		
		for(int i = 0; i < library.length; i++){
			shown = shown + (i + 1) + "<&nbsp; <&nbsp;" + library[i].toDisplay() + "<br/>";
		}
		
		shown = shown + "<html>";
		textDisplayLBL.setText(shown);
	}

	//sorts with help from java t point (https://www.javatpoint.com/insertion-sort-in-java)
	private void sortTitle(){
		for(int i = 1; i < library.length;i++){
			Song key = library[i];
			int j = i-1;
			while((j > -1) && (library[j].compareTitle(key) > 0)){
				library[j+1] = library[j];
				j--;
			}
			library[j+1] = key;		
		}
	}

	private void sortArtist(){
		for(int i = 1; i < library.length;i++){
			Song key = library[i];
			int j = i-1;
			while((j > -1) && (library[j].compareArtist(key) > 0)){
				library[j+1] = library[j];
				j--;
			}
			library[j+1] = key;		
		}
	}

	private void sortLength(){
		for(int i = 1; i < library.length;i++){
			Song key = library[i];
			int j = i-1;
			while((j > -1) && (library[j].compareLength(key) > 0)){
				library[j+1] = library[j];
				j--;
			}
			library[j+1] = key;		
		}
	}
//remove songs that dont have the searched term
	private void searchMethod(String p){
		//System.out.println("p = " + p);
		for(int i = 0; i < library.length;i++){
			if(!(library[i].toString().contains(p))){
				removeSong(library[i]);
				i--;
				//because librarry length and i increase  happens at same time, i effectivly goes up by two. This solves that. Took me 2 hours to figure that out :)
			}
		}
	}
	
}