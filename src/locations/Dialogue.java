package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import mainGame.MainGame;
import mainGame.Options;
import mainGame.TimerClass;


public class Dialogue extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, nextVisible;
	Player player;
	int textSpeed;
	Rival rival;
	JButton menuButton, returnButton, nextButton;
	TimerClass tm;
	PalletTownYourHouse palletTownYourHouse;
	JTextArea textArea;
	String text = "";
	
	public Dialogue (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean nextVisible) {
		
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.screen = screen;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.stopTimer = stopTimer;
	     this.location = location2;
	     
	     setBackground(Color.black);
	     
	     JButton returnButton = new JButton("Return");
		 returnButton.setPreferredSize(new Dimension(150,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
		 JButton nextButton = new JButton("Next");
		 nextButton.setPreferredSize(new Dimension(150,75));
		 nextButton.setBackground(Color.DARK_GRAY);
		 nextButton.setForeground(Color.cyan);
		 nextButton.setFont(font);
		 nextButton.setVisible(nextVisible);
		 
		 textArea = new JTextArea();		 
		 textArea.setForeground(Color.cyan);
		 textArea.setBackground(Color.black);
		 textArea.setFont(font);
	     
		 if (language == "Japanese") {
			 returnButton.setText("とじる");
			 nextButton.setText("つぎ");
		 }
		 
		 switch (screen) {
		 case "playsnes": 
			 if (language == "English") {
				 text = player.getName() + " is playing the SNES! ...Okay! It's time to go!";
				 }
			 else {
				 text = player.getName() + "は　ファミコンを　してる! "
				 		+ "\n" + "。。。。。。　。。。。。。"
				 		+ "\n　よし！　そろそろ　でかけよう！";
				 }
			 break;
		 case "watchtv": 
			 if (language == "English") {
				 text = "There's a movie on TV. Four boys are walking on railroad tracks.\n" + 
				 		"I better go too.";
				 }
			 else {
				 text = "テレビで　えいがを　やってる！\n　おとこのこが　４にん　せんろのうえを　あろいてる　\n　。。。。。。。。。。。。 \n"
				 		+ "ぼくも　もう　いかなきゃ！ ";
				 }
			 break;
			 
		 case "talktomom": 
			 if (language == "English") {
				 text = "Mom: Right. All boys leave home some day. It said so on TV.\n" + 
				 		"PROF.OAK, next door, is looking for you.";
				 }
			 else {
				 text = "おかあさん：　そうね　おとこのこは　いつか \n　たびに　でるもの　なのよ　うん。。。。。。\n　テレビの　はなしよ！"
				 		+ "そういえば　オーキドはかせが \n　あなたを　よんでたわよ";
				 }
			 break;
			 
		 case "talktorivalsister": 
			 if (language == "English") {
				 text = rival.getName() + "'s Sis: Hi " + player.getName() + "! " + rival.getName() + 
						 " is out at Grandpa's lab.";
				 }
			 else {
				 text = "こんいちわ " + player.getName() + "くん！" + "\n" +"おとうとの　"+ rival.getName() + "なら"
			 + "\n" +"おじいちゃんの　けんきゆうじょよ";
				 }
			 break;
			 
		 case "pickupmap": 
			 if (language == "English") {
				 text = "It's a big map! This is useful! \n *Map added to inventory*";
				 }
			 else {
				 text = "カントー　ちほうの　ちずだ！。。。。。" + "\n" +"もらえたら　うれしい？";
				 }
			 break;
			 
		 case "oakaid1lab": 
			 if (language == "English") {
				 text = "I study POKEMON as PROF.OAK'S AIDE.";
				 }
			 else {
				 text ="わたしも　はかせの　じょしゅ" + "\n"+"として　ポケモンを　けんきゅう　してます";
				 }
			 break;
			 
		 case "oakaid2lab": 
			 if (language == "English") {
				 text = "I study POKEMON as PROF.OAK'S AIDE.";
				 }
			 else {
				 text ="わたしも　はかせの　じょしゅ" + "\n"+"として　ポケモンを　けんきゅう　してます";
				 }
			 break;
			 
		 case "oakaid3lab": 
			 if (language == "English") {
				 text = "PROF.OAK is the authority on POKEMON! \n Many POKEMON trainers hold him in high regard!";
				 }
			 else {
				 text =  "ああ　みえても　オーキドはかせは" + "\n"+"ポケモンの　オーキドリテイなの！"+ "\n" + 
						 "はかせを　そんけいする　ポケモン" + "\n" +"トレーナーモ　おおいわよ！";
				 }
			 break;
			 
		 case "poster1lab": 
			 if (language == "English") {
				 text = "Push START to open the MENU!";
				 }
			 else {
				 text = "スタート　ボタンを　プシュ！"+"\n" + "おすと　メニユーが　ひらくなリ";
				 }
			 break;
			 
		 case "poster2lab": 
			 if (language == "English") {
				 text = "The SAVE option is on the MENU screen.";
				 }
			 else {
				 text = "セーブするには　ポケモン　レポート" + "\n" +"こまめに　かくと　いいなリ";
				 }
			 break;
			 
		 case "booklab": 
			 if (language == "English") {
				 text = "It's encyclopedia-like, but the pages are blank!";
				 }
			 else {
				 text = "ずかん　みたいな　ものが　ある！" + "\n" + "なかは　しろいぺージ　ばっかリだ！";
				 }
			 break;
			 
		 case "computerlab": 
			 if (language == "English") {
				 text = "There's an e-mail message here! ... Calling all POKEMON trainers! \n "
				 		+ "The elite trainers of POKEMON LEAGUE are ready to take on all \n"
				 		+ "comers! Bring your best POKEMON and see how you rate as a trainer! \n\n"
				 		+ "POKEMON LEAGUE HQ INDIGO PLATEAU \n PS: PROF.OAK, please visit us! ...";
				 }
			 else {
				 text = "パソコンを　みると　なんと"+"\n" + "でんしメールが　きていた！"+"\n"+"。。。。。。　。。。。。。　。。。。。。"+"\n"+
			 "ポケモンを　つよく　そだてて　たたかう"+"\n"+"ポケモン　トレーナー！　ここに　さいきょうの"+"\n"+"トレーナーが　あつまリ　ました"+ "\n"+
						 "ばしょは　セキエイ　こうだんの"+"\n"+"ポケモン　リーグ　ほんぶ　です！"+"\n"+
			 "オーキドはかせも　いちど　ごらん　ください。。。。。。。"+"\n"+"ポケモン　リーグ　よリ。。。。。。　。。。。。。　。。。。。。";
				 }
			 break;
			 
		 case "pokeballlab": 
			 if (language == "English") {
				 text = "Those are POKE BALLS. They contain POKEMON!";
				 }
			 else {
				 text = "モンスターボールだ　なかに" + "\n" +"ポケモンが　はいってるぞ！";
				 }
			 break;
			 
		 case "rivallab": 
			 if (language == "English") {
				 text = "Yo " + player.getName() + "! Gramps isn't around!";
				 }
			 else {
				 text = rival.getName()+": なんだー " + player.getName() + "か！" + "\n" + 
			 "オーキドの　じいさんなら　いねーよ";
				 }
			 break;
			 
		 case "professoroaklab": 
			 if (language == "English") {
				 text = "";
				 }
			 else {
				 text = "";
				 }
			 break;
		 
		 }
		 
		 tm = new TimerClass(text, stopTimer, textSpeed , textArea);
	     
	     
	     
	     setBackground(Color.black);
	     setLayout(new GridBagLayout());
	     GridBagConstraints gb = new GridBagConstraints();
	     
	     if (nextButton.isVisible()) {
	     gb.gridx=0;
	     gb.gridy=0;
	     gb.weighty = 1;
	     gb.insets = new Insets(-100,0,0,0);
	     add(returnButton, gb);
	     
	     gb.gridx=0;
	     gb.gridy=1;
	     gb.insets = new Insets(25,0,0,0);
	     add(textArea, gb);
	     
	     gb.gridx=0;
	     gb.gridy=2;
	     add(nextButton, gb);
	     }
	     else {
	    	 
	    	 gb.gridx=0;
		     gb.gridy=0;
		     add(returnButton, gb);
		     
		     gb.gridx=0;
		     gb.gridy=1;
		     gb.weighty = 1;
		     gb.insets = new Insets(-150,0,0,0);
		     add(textArea, gb);
	    	 
	     }
	     
	     
	     returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	switch (location) {
	            	
	            	case "pallettownyourhouse":
	            		
	            		palletTownYourHouse = new PalletTownYourHouse(layout, cards, 
	            				font, screen, language, textSpeed, 
	            				player, rival, stopTimer, location);
	            		cards.add(palletTownYourHouse, "pallettownyourhouse");
	            	    layout.show(cards, "pallettownyourhouse");
	            	    break;
	            	    
	            	case "pallettownrivalhouse":
	            		
	            		PalletTownRivalHouse palletTownRivalHouse = new PalletTownRivalHouse(layout, cards, 
	            				font, screen, language, textSpeed, 
	            				player, rival, stopTimer, location);
	            		cards.add(palletTownRivalHouse, "pallettownrivalhouse");
	            	    layout.show(cards, "pallettownrivalhouse");
	            	    break;
	            	    
	            	case "pallettownlab":
	            		PalletTownLab palletTownLab = new PalletTownLab(cl, cards, textAreaFont, "12", language, textSpeed,
		            			player, rival, stopTimer, "pallettownyourhouse");
		            	cards.add(palletTownLab, "pallettownlab");
		                layout.show(cards, "pallettownlab");  
		                break;
	            		
	            	}
	            	
	            	

	            	    
	                
	            				}	
	            			}
				 		);
		
	}
	
}
