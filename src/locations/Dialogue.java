// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

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
	int textSpeed, screenNumber;
	Rival rival;
	JButton menuButton, returnButton, nextButton;
	TimerClass tm;
	PalletTownYourHouse palletTownYourHouse;
	JTextArea textArea;
	String text = "";
	Boolean professorOakVisited, returnVisible, labOutsideButtonEnable;
	String color;
	
	public Dialogue (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean nextVisible, Boolean professorOakVisited2,
			Boolean returnVisible, int screenNumber2, Boolean labOutsideButtonEnable, String color) {
		
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
		 this.professorOakVisited=professorOakVisited2;
	     this.returnVisible = returnVisible;
	     this.screenNumber = screenNumber2;
	     this.labOutsideButtonEnable = labOutsideButtonEnable;
	     this.color = color;
	     
//	     if (color == "black") {
//	         setBackground(Color.black); 
//	 	    }
//	 	    
//	 	    if (color == "cyan") {
//	 	        setBackground(Color.cyan); 
//	 		    }
	     
	     setBackground(Color.black); 
	     
	     JButton returnButton = new JButton("Return");
		 returnButton.setPreferredSize(new Dimension(150,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 returnButton.setVisible(returnVisible);
		 
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
			 if (professorOakVisited == false) {
			 if (language == "English") {
				 text = "Yo " + player.getName() + "! Gramps isn't around!";
				 }
			 else {
				 text = rival.getName()+": なんだー " + player.getName() + "か！" + "\n" + 
			 "オーキドの　じいさんなら　いねーよ";
				 }
			 }
			 
			 else {
				 if (language == "English") {
					 text = rival.getName() + ": Heh, I don't need to be greedy like you!" + "\n" + 
				 "Go ahead and choose, " + player.getName() + "!";
					 }
				 else {
					 text = rival.getName() + ": へへーんだ！　おれは　おとな　だから　がっ つかないのさ" + "\n" + player.getName() +
							 "から　さきに　えらばせて　やるぜ！";
					 }
			 }
			 break;
			 
		 case "professoroaklab": 
			 if (language == "English") {
				 text = "Oak: If a wild POKEMON appears, your POKEMON can fight against it!";
				 }
			 else {
				 text = "オーキド：　さあ　" + player.getName() + "どの　ポケモンに　する？";
				 }
			 break;
			 
		 case "route1oak": 
			 switch(screenNumber) {
			 case 0:
			 if (language == "English") {
				 text = "*When trying to leave town via the grassy path to the north* \n" + 
				 		"\n" + 
				 		"Oak: Hey! Wait! Don't go out!\n" + 
				 		"\n" + 
				 		"* - Oak approaches " + player.getName() + ".\n" + 
				 		"\n" + 
				 		"Oak: It's unsafe! Wild POKEMON live in tall grass! You need your own\n" + 
				 		"            POKEMON for your protection. I know! Here, come with me!\n" + 
				 		"\n" + 
				 		"*He takes " + player.getName() + " to his laboratory. They approach a table upon which three\n" + 
				 		"    Poke Balls have been placed, and next to which " + rival.getName() + " is present.*";
				 }
			 else {
				 text = "オーキド： おーい！　まてー！　まつんじゃあ" + "\n" + "あぶない　とこだった　くさむらでは やせいの　ポケモンが　とびだす！"+ "\n" +
			 "こちらも　ポケモンを　もって　いれば　たたかえるのだが。。。。。。" + "\n" + "そうじゃ！。。。。。。。　ちょうっと　わしに　ついて　さなさい！";
				 }
			 break;
			 
			 case 1:
				 if (language == "English") {
					 text = rival.getName() + ": Gramps! I'm fed up with waiting!\n" + 
					 		"\n" + 
					 		"Oak: " + rival.getName() + "? Let me think... Oh, that's right, I told you to come!\n" + 
					 		"            Just wait!\n" + 
					 		"\n" + 
					 		"            Here," + player.getName() + "! There are 3 POKEMON here! Haha! They are inside the\n" + 
					 		"            POKE BALLS. When I was young, I was a serious POKEMON trainer.\n" + 
					 		"            In my old age, I have only 3 left, but you can have one! Choose!\n" + 
					 		"\n" + 
					 		rival.getName() + ": Hey! Gramps! What about me?\n" + 
					 		"\n" + 
					 		"Oak: Be patient! " + rival.getName() + ", you can have one too!";
					 }
				 else {
					 text = rival.getName() + ": じいさん！　まちくたびれたぞー！" + "\n" + "オーキド：　" + rival.getName() + 
							 "か？　。。。。。。　。。。。。。　。。。。。。" + "\n" + "ああ　そうか　わしが　よんだのじゃった！ちょうと　まって　おれ！" + "\n" +
							 "ほれ　" + player.getName() + "! そこに　３びき　ポケモンが　いる　じゃろう！　ほつほ！";
							
					 }
				 break;
			 case 2:
				 if (language == "English") {
					 text = "Oak: Now, " + player.getName() + ", which POKEMON do you want?\n" + 
					 		"\n" + 
					 		rival.getName() + ": Heh, I don't need to be greedy like you! Go ahead and choose, " + 
					 		player.getName() + "!";
					 }
				 else {
					 text =  "モンスターボールの　なかに　ポケモンが" + "\n" +"いれて　あるんじゃ　すかしは" + "\n" + 
							 "わしも　バリバリの　ポケモン" + "\n" +"トレーモーとして　ならした　もの" + "\n" + 
							 "おいばれた　いまは　ポケモンも　３びき" + "\n" +"しか　のこっとらんが"
						 		+ "おまえに　１ぴき" + "\n" +"やろう！。。。。。。　さあ　えらべ！" + "\n" + rival.getName() + ": あツ！　ずろい！　じいさん！"
						 				+ "おれにも"+ "\n" + "くれよお！ オーキド：　まー！　あわてるな　"+ rival.getName() + "\n" + "!" + 
						 				"おまえも　すきなものを　とれ！";
					 }
				 break;
			 
			 
			 }
			 break;
			 
		 case "starterchosen": 
			 if (language == "English") {
				 text = "Oak: This POKEMON is really energetic!" + 
				 		"\n" + "*" + player.getName() + 
				 		" takes the Pokemon.*" + 
				 		"\n" + 
				 		rival.getName() + ": I'll take this one, then!" + 
				 		"\n" + 
				 		"*" + rival.getName() + " chooses whichever Pokemon has"
				 				+ "\n" + " a type advantage over Red's selection.*";
			 }
			 
			 else {
				 text = "この　ポケモンは　ほんとに　げんきが　いいぞ！"+"\n"+player.getName()+"*は　オーキドから " +player.getPartyPokemonName1(language)+ 
						 "を　もらった!*"+"\n" + rival.getName() + "：おれは　これ！" + rival.getName() + "は　オーキドから　"+"\n"+rival.getPartyPokemonName1(language) 
						 +"を　もらった！";
			 }
			 break;
			 
		 case "rivalbattle1": 
			 if (language == "English") {
				 text = rival.getName() + ": Wait " + player.getName() + "!" + "\n" + "Let's check out our Pokémon!" + "\n"
				 		+ "Come on, I'll take you on!";
			 }
			 
			 else {
				 text = rival.getName() + ": まてよ！　" + player.getName() + "!" + "\n" + "せっかく　じーさんに　ポケモン　もらったんだせ！" + "\n" +
			 "。。。。。。ちょっと　おれの　あいて　してみろ！";
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
	            				player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, color);
	            		cards.add(palletTownYourHouse, "pallettownyourhouse");
	            	    layout.show(cards, "pallettownyourhouse");
	            	    break;
	            	    
	            	case "pallettownrivalhouse":
	            		
	            		PalletTownRivalHouse palletTownRivalHouse = new PalletTownRivalHouse(layout, cards, 
	            				font, screen, language, textSpeed, 
	            				player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, color);
	            		cards.add(palletTownRivalHouse, "pallettownrivalhouse");
	            	    layout.show(cards, "pallettownrivalhouse");
	            	    break;
	            	    
	            	case "pallettownlab":
	            		PalletTownLab palletTownLab = new PalletTownLab(cl, cards, textAreaFont, "12", language, textSpeed,
		            			player, rival, stopTimer, "pallettownlab", professorOakVisited, labOutsideButtonEnable, color);
		            	cards.add(palletTownLab, "pallettownlab");
		                layout.show(cards, "pallettownlab");  
		                break;
	            		
	            	}
	            	               
	            				}	
	            			}
				 		);
	     
	     nextButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	
	            	switch (location) {
	            	
	            	case "route1oak":
	            		
	            		if (screenNumber == 2) {
	            			professorOakVisited = true;
	            			PalletTownLab palletTownLab = new PalletTownLab(cl, cards, textAreaFont, 
	    	                		"12", language, textSpeed, player, rival, stopTimer, "pallettownlab", professorOakVisited, 
	    	                		false, color);
	    	            	cards.add(palletTownLab, "pallettownlab");
	    	            	
	    	                layout.show(cards, "pallettownlab");
	    	                cl.show(cards, "pallettownlab"); 
	            		}
	            		
	            		
	            		else {
	            		Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "route1oak", language, textSpeed,
			         			player, rival, stopTimer, "route1oak", true, professorOakVisited, false, screenNumber +1,
			         			labOutsideButtonEnable, color);
			         	cards.add(dialogue, "dialogue");
			             cl.show(cards, "dialogue"); 
	            		}
	            		break;
	            	case "pallettownlab":
	            		PalletTownLab palletTownLab = new PalletTownLab(cl, cards, textAreaFont, 
		                		"12", language, textSpeed, player, rival, stopTimer, "pallettownlab",
		                		professorOakVisited, false, color);
		            	cards.add(palletTownLab, "pallettownlab");
		            	
		                layout.show(cards, "pallettownlab");
	            		break;
	            
	            	    
	            		
	            	}
	            	
	            	switch (screen) {
	            	case "rivalbattle1":
	            		Battle battle = new Battle(cl, cards, textAreaFont, 
		                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
		                		labOutsideButtonEnable, rival, 0, color, false, "", "", "", "pallettownlab");
		            	cards.add(battle, "battle");
		            	
		                layout.show(cards, "battle");
		                break;
	            	}
	            	
	            	

	            	    
	                
	            				}	
	            			}
				 		);
		
	}
	
}
