import java.util.*;

public class GameScenes {
  static ArrayList<Scene> sceneList = new ArrayList<Scene>();

  public static ArrayList<Scene> loadScenes(){
  	Scene evilHat = new Scene("Evil Wear a Hat", 4, "Calhoun is separated from the group during a white-knuckled chase near Desperation Bluff.", "images/cards/01.png");
    evilHat.onCardRoles.add(new Role("Defrocked Priest", 2, true, "Look out below!", 20, 47));
    evilHat.onCardRoles.add(new Role("Marshal Canfield", 3, true, "Hold fast!", 87, 47));
    evilHat.onCardRoles.add(new Role("One-Eyed Man", 4, true, "Balderdash!", 145, 47));
    sceneList.add(evilHat);

    Scene lawOldWest = new Scene("Law and the Old West", 3, "Charlie \'Three Guns\' Henderson cooperates with Johnny Law and reluctantly enters the witless protection program.", "images/cards/02.png");
    lawOldWest.onCardRoles.add(new Role("Rug Merchant", 1, true, "Don't leave my store!", 20, 47));
    lawOldWest.onCardRoles.add(new Role("Banker", 2, true, "Trust me.", 87, 47));
    lawOldWest.onCardRoles.add(new Role("Talking Mule", 4, true, "Nice work, Johnny!", 145, 47));
    sceneList.add(lawOldWest);

  	Scene johnSkywater = new Scene("The Life and Times of John Skywater", 5, "Disheartened by his lack of business acumen and his poor choice of investment partners, John Skywater sets off into the Cree Nation to convince them to kidnap his wife.", "images/cards/03.png");
    johnSkywater.onCardRoles.add(new Role("Auctioneer", 5, true, "Going once!", 53, 47));
    johnSkywater.onCardRoles.add(new Role("General Custer", 6, true, "Go West!", 115, 47));
    sceneList.add(johnSkywater);

    Scene prairieYears = new Scene("My Years on the Prairie", 5, "Virgil and Stacy set out at midnight to track down the stray cows, unaware that they are being pursued by inch-high aliens from outer space.", "images/cards/04.png");
    prairieYears.onCardRoles.add(new Role("Drunk", 3, true, "Where's Willard?", 20, 47));
    prairieYears.onCardRoles.add(new Role("Librarian", 4, true, "Shhhhh!", 83, 47));
    prairieYears.onCardRoles.add(new Role("Man with Hay", 6, true, "Hey!", 145, 47));
    sceneList.add(prairieYears);

    Scene buffaloBill = new Scene("Buffalo Bill: The Lost Years", 4, "Buffalo Bill's companion Marty disappears in a freak electrical storm. Bill enlists the aid of the Sidekick Friends network.", "images/cards/05.png");
    buffaloBill.onCardRoles.add(new Role("Hollaring Boy", 2, true, "Over here, mister!", 20, 47));
    buffaloBill.onCardRoles.add(new Role("Drink Farmer", 3, true, "Git outta me barn!", 83, 47));
    buffaloBill.onCardRoles.add(new Role("Meek Little Sarah", 5, true, "He's so cute!", 145, 47));
    sceneList.add(buffaloBill);

    Scene squareCity = new Scene("Square Deal City", 6, "Douglas and Katherine confront Aunt Martha about her missing pies.  Devin sulks quietly in a side room." ,"images/cards/06.png");
    squareCity.onCardRoles.add(new Role("Squaking Boy", 2, true, "I'll say!", 20, 47));
    squareCity.onCardRoles.add(new Role("Pharaoh Imhotep", 4, true, "Attack, soldiers!", 83, 47));
    squareCity.onCardRoles.add(new Role("Aunt Martha", 6, true, "You got nothin'!", 145, 47));
    sceneList.add(squareCity);

    Scene davyCrockett = new Scene("Davy Crockett: A Drunkard's Tale", 4, "Robert enlists the aid of several farm animals in order to ascertain the efficacy of his new hangover remedy.", "images/cards/07.png");
    davyCrockett.onCardRoles.add(new Role("The Duck", 4, true, "Waaaak!", 53, 47));
    davyCrockett.onCardRoles.add(new Role("His Brother", 6, true, "Waaaaaaaak!", 115, 47));
    sceneList.add(davyCrockett);

    Scene wayWestWasRun = new Scene("The Way the West Was Run", 4, "Jose explains patiently, but with thinly veiled contempt, the intricacies of Arizona bureaucracy, as though speaking to a simple and distracted child.", "images/cards/08.png");
    wayWestWasRun.onCardRoles.add(new Role("Town Drunk", 2, true, "Even me!", 20, 47));
    wayWestWasRun.onCardRoles.add(new Role("Squinting Miner", 4, true, "Sure we can!", 83, 47));
    wayWestWasRun.onCardRoles.add(new Role("Poltergeist", 5, true, "Wooooo!", 145, 47));
    sceneList.add(wayWestWasRun);

    Scene inTheValley = new Scene("Down in the Valley", 3, "A tripped waiter is the spark igniting a brawl of cataclysmic proportions.  Walter is injured in the neck.", "images/cards/09.png");
    inTheValley.onCardRoles.add(new Role("Angry Barber", 1, true, "Hold him still!", 20, 47));
    inTheValley.onCardRoles.add(new Role("Woman with Board", 3, true, "Nonsense, Frank!", 83, 47));
    inTheValley.onCardRoles.add(new Role("Man in Fire", 5, true, "It burns!", 145, 47));
    sceneList.add(inTheValley);

    Scene olShooter = new Scene("Ol' Shooter and Little Doll", 4, "Shooter discovers that he has been proceeding for days with no trousers. This causes him no small embarrassment as he searches for them with Little Doll.", "images/cards/10.png");
    olShooter.onCardRoles.add(new Role("Sleeping Man", 1, true, "Snnkkk snnkk snnkk.", 20, 47));
    olShooter.onCardRoles.add(new Role("Man with Pig", 2, true, "Tally-Hooo!", 83, 47));
    olShooter.onCardRoles.add(new Role("Shooter", 4, true, "Where's my britches?", 145, 47));
    sceneList.add(olShooter);

    Scene trainRobbers = new Scene("The Robbers of Trains", 4, "Coogan confronts the toughest thug in his gang, Big Jake, in an abbreviated knife fight.  Coogan settles the dispute with fearless guile and a kick in the family jewels.", "images/cards/11.png");
    trainRobbers.onCardRoles.add(new Role("Buster", 1, true, "One two three go!", 20, 47));
    trainRobbers.onCardRoles.add(new Role("Man Reading Paper", 4, true, "Ouchie!", 83, 47));
    trainRobbers.onCardRoles.add(new Role("Fat Pete", 5, true, "Nick kick, boss!", 145, 47));
    sceneList.add(trainRobbers);

    Scene beyondPail = new Scene("Beyond the Pail: Life without Lactose", 2, "Henry discovers for the first time that his ability to digest cream has disappeared along with his hair.  Other cowboys attempt to console him.", "images/cards/12.png");
    beyondPail.onCardRoles.add(new Role("Martin", 6, true, "Have you tried soy cheese?", 83, 47));
    sceneList.add(beyondPail);

    Scene manCow = new Scene("A Man Called 'Cow'", 3, "Nothing will settle the debates among the skeptical locals, short of a demonstration of Hector's special talents.", "images/cards/13.png");
    manCow.onCardRoles.add(new Role("Preacher", 3, true, "My word!", 53, 47));
    manCow.onCardRoles.add(new Role("Amused Witness", 6, true, "Tee hee hee!", 115, 47));
    sceneList.add(manCow);

    Scene taffyCommercial = new Scene("Taffy Commercial", 2, "Jackson encourages the children to eat only taffy, because gum can kill them stone dead.", "images/cards/14.png");
    taffyCommercial.onCardRoles.add(new Role("Curious girl", 3, true, "Are you sure?", 53, 47));
    taffyCommercial.onCardRoles.add(new Role("Ghost of Plato", 4, true, "It happened to me!", 115, 47));
    sceneList.add(taffyCommercial);

    Scene gumCommercial = new Scene("Gum Commercial", 2, "Inspector Pete speaks to a riveted audience about the many hidden dangers of taffy, not the least of which is that taffy can kill you stone dead.", "images/cards/15.png");
    gumCommercial.onCardRoles.add(new Role("Surprised Bison", 2, true, "Mmrrrrrph!", 53, 47));
    gumCommercial.onCardRoles.add(new Role("Man with Horn", 4, true, "Ta daaaa!", 115, 47));
    sceneList.add(gumCommercial);

    Scene jesseJames = new Scene("Jesse James: Man of Action", 5, "Jesse's brothers Jed and Henry throw him a surprise birthday party. Jesse's nerves get the better of him when the birthday cake explodes.", "images/cards/16.png");
    jesseJames.onCardRoles.add(new Role("Shot in Back", 2, true, "Arrrggh!", 20, 47));
    jesseJames.onCardRoles.add(new Role("Shot in Leg", 4, true, "Ooh, lordy!", 83, 47));
    jesseJames.onCardRoles.add(new Role("Leaps into Cake", 5, true, "Dangit, Jesse!", 145, 47));
    sceneList.add(jesseJames);

    Scene disasterJ = new Scene("Disaster at Flying J", 5, "After the mine explosion, the traveling circus takes time out to get drunk and start a fight.", "images/cards/17.png");
    disasterJ.onCardRoles.add(new Role("Piano Player", 2, true, "It's a nocturne!", 20, 47));
    disasterJ.onCardRoles.add(new Role("Man in Turban", 3, true, "My stars!", 83, 47));
    disasterJ.onCardRoles.add(new Role("Falls on Hoe", 4, true, "Ow!", 145, 47));
    sceneList.add(disasterJ);

    Scene shakespearLubbock = new Scene("Shakespear in Lubbock", 3, "William decides that it is time to be movin' on.  Julia convinces him to stick around just long enough to get into big trouble.", "images/cards/18.png");
    shakespearLubbock.onCardRoles.add(new Role("Falls from Tree", 1, true, "What ho!", 20, 47));
    shakespearLubbock.onCardRoles.add(new Role("Laughing Woman", 3, true, "Tis to laugh!", 83, 47));
    shakespearLubbock.onCardRoles.add(new Role("Man with Whistle", 4, true, "Tweeeeet!", 145, 47));
    sceneList.add(shakespearLubbock);

    Scene goWest = new Scene("Go West, You!", 3, "Susan and Peter encounter some of the perils of the Badlands: rutted mud roads, torrential rain storms, and a bad case of \'grumbly tummy.\'", "images/cards/19.png");
    goWest.onCardRoles.add(new Role("Ex-Convict", 4, true, "Never again!", 53, 47));
    goWest.onCardRoles.add(new Role("Man with Onion", 6, true, "Fresh Onions!", 115, 47));
    sceneList.add(goWest);

    Scene johnSkywalkerB = new Scene("The Life and Times of John Skywater", 5, "John discovers his long-lost sister Marcie, and instructs her in the ways of gunfighting and whiskey distillation.", "images/cards/20.png");
    johnSkywalkerB.onCardRoles.add(new Role("Staggering Man", 3, true, "You never know!", 20, 47));
    johnSkywalkerB.onCardRoles.add(new Role("Woman with Beer", 5, true, "Howdy, stranger!", 83, 47));
    johnSkywalkerB.onCardRoles.add(new Role("Marcie", 6, true, "Welcome home!", 145, 47));
    sceneList.add(johnSkywalkerB);

    Scene gunMusical = new Scene("Gun! The Musical", 6, "A song and dance extravaganza, \'Hunka Hunka Burnin' Lead.\'", "images/cards/21.png");
    gunMusical.onCardRoles.add(new Role("Looks like Elvis", 4, true, "Thankyouverymuch.", 20, 47));
    gunMusical.onCardRoles.add(new Role("Singing Dead Man", 5, true, "Yeah!", 83, 47));
    gunMusical.onCardRoles.add(new Role("Apothecary", 6, true, "Such drugs I have.", 145, 47));
    sceneList.add(gunMusical);

    Scene humorExpense = new Scene("Humor at the Expense of Others", 5, "Phil and his cohort of unfeeling smart-mouths make fun of Sancho and his great big hat.", "images/cards/22.png");
    humorExpense.onCardRoles.add(new Role("Jailer", 2, true, "You there!", 20, 47));
    humorExpense.onCardRoles.add(new Role("Mephistopheles", 4, true, "Be not afraid!", 83, 47));
    humorExpense.onCardRoles.add(new Role("Breaks a Window", 5, true, "Oops!", 145, 47));
    sceneList.add(humorExpense);

  Scene search = new Scene("The Search for Maggie White", 6, "Alone in the wilderness, Maggie makes the best of her situation. In what seems like no time at all, she constructs a sturdy two-story house from branches and mud.", "images/cards/23.png");
  search.onCardRoles.add(new Role("Film Critic", 5, true, "Implausible!", 53, 47));
  search.onCardRoles.add(new Role("Hobo with Bat", 6, true, "Nice house!", 115, 47));
  sceneList.add(search);

  Scene picante = new Scene("Picante Sauce Commercial", 2, "A dozen grizzled cowboys surround a fire. Suddenly, they exclaim, \'That's not mayonnaise!\'", "images/cards/24.png");
  picante.onCardRoles.add(new Role("Bewhisker'd Cowpoke", 3, true, "Oh, sweet Lord!", 53, 47));
  picante.onCardRoles.add(new Role("Dog", 6, true, "Wurf!", 115, 47));
  sceneList.add(picante);

  Scene jesseJames2 = new Scene("Jesse James: Man of Action", 5, "A hail of gunfire results when Jesse's friend Barton marries Jesse's childhood sweetheart.", "images/cards/25.png");
  jesseJames2.onCardRoles.add(new Role("Shot in Head", 1, true, "Arrrgh!", 20, 47));
  jesseJames2.onCardRoles.add(new Role("Leaps Out of Cake", 4, true, "Oh, for Pete's sake", 83, 47));
  jesseJames2.onCardRoles.add(new Role("Shot Three Times", 6, true, "Ow! Ow! Ow!", 145, 47));
  sceneList.add(jesseJames2);

  Scene falseStep = new Scene("One False Step for Mankind", 6, "After a dozen failed attempts, one rocket carries Horatio and his six children to the Moon, where they enjoy a picnic and a spirited game of badminton.", "images/cards/26.png");
  falseStep.onCardRoles.add(new Role("Flustered Man", 1, true, "Well, I never!", 20, 47));
  falseStep.onCardRoles.add(new Role("Space Monkey", 2, true, "Ook!", 83, 47));
  falseStep.onCardRoles.add(new Role("Cowbot Dan", 5, true, "Bzzzzzt!", 145, 47));
  sceneList.add(falseStep);

  Scene thirteen = new Scene("Thirteen the Hard Way", 5, "After some delay, the Pony Express arrives. Isaac, Gwen, Francis, Terry, Conrad, Brooke, Jerry, Howard, MacNeill, Jones, Spike, Cornwall and Crawford are all there.", "images/cards/27.png");
  thirteen.onCardRoles.add(new Role("Man in Poncho", 1, true, "Howdy, Jones!", 20, 47));
  thirteen.onCardRoles.add(new Role("Ecstatic Housewife", 3, true, "This is fine!", 83, 47));
  thirteen.onCardRoles.add(new Role("Isaac", 5, true, "The mail!", 145, 47));
  sceneList.add(thirteen);

  Scene milk = new Scene("How They Get Milk", 4, "Josie asks the Milkman how they get milk. After a thoughtful pause, he begins. \'Not like you'd expect!\'", "images/cards/28.png");
  milk.onCardRoles.add(new Role("Cow", 2, true, "Moo.", 20, 47));
  milk.onCardRoles.add(new Role("St. Clement of Alexandria", 3, true, "Peace be with you, child!", 83, 47));
  milk.onCardRoles.add(new Role("Josie", 4, true, "Yikes!", 145, 47));
  sceneList.add(milk);

  Scene prairie = new Scene("My Years on the Prairie", 5, "Louise takes instruction from Henry, the neighbor boy, in an absurdly suggestive explanation of how to plow a field.", "images/cards/29.png");
  prairie.onCardRoles.add(new Role("Willard", 2, true, "Ain't that a sight?", 20, 47));
  prairie.onCardRoles.add(new Role("Leprechaun", 3, true, "Begorrah!", 83, 47));
  prairie.onCardRoles.add(new Role("Startled Ox", 5, true, "Mrr?", 145, 47));
  sceneList.add(prairie);

  Scene davyCrockett2 = new Scene("Davy Crockett: A Drunkard's Tale", 4, "In an absurd dream sequence, Crockett recalls an episode of fear and chaos in which his childhood friend Timmy was trapped at the bottom of a well.", "images/cards/30.png");
  davyCrockett2.onCardRoles.add(new Role("Voice of God", 2, true, "Grab hold, son!", 20, 47));
  davyCrockett2.onCardRoles.add(new Role("Hands of God", 3, true, "!", 83, 47));
  davyCrockett2.onCardRoles.add(new Role("Jack Kemp", 4, true, "America!", 145, 47));
  sceneList.add(davyCrockett);

  Scene czechs = new Scene("Czechs in the Sonora", 4, "Bob reverts to his ancestral ways in a short fight  over a disembodied hand.", "images/cards/31.png");
  czechs.onCardRoles.add(new Role("Opice (Monkey)", 5, true, "Ukk! (Ook)!", 53, 47));
  czechs.onCardRoles.add(new Role("Man with Gun", 6, true, "Hold it right there!", 115, 47));
  sceneList.add(czechs);

	Scene swingEm = new Scene("Swing 'em Wide", 6, "Black Jack invites Dixon and The Captain to a late-night poker game. Little do they know that Gertrude and Isabella await them at the table.", "images/cards/32.png");
  swingEm.onCardRoles.add(new Role("Thrifty Mike", 1, true, "Call!", 20, 47));
  swingEm.onCardRoles.add(new Role("Sober Physician", 3, true, "Raise!", 83, 47));
  swingEm.onCardRoles.add(new Role("Man on Floor", 5, true, "Fold!", 145, 47));
  sceneList.add(swingEm);

  Scene swingEm2 = new Scene("Swing 'em Wide", 6, "Hector makes a surprising discovery behind the Chinese grocery store.", "images/cards/33.png");
  swingEm2.onCardRoles.add(new Role("Liberated Nun", 3, true, "Let me have it!", 20, 47));
  swingEm2.onCardRoles.add(new Role("Witch Doctor", 5, true, "Oogie Boogie!", 83, 47));
  swingEm2.onCardRoles.add(new Role("Voice of Reason", 6, true, "Come on, now!", 145, 47));
  sceneList.add(swingEm2);

  Scene trials = new Scene("Trials of the First Pioneers", 4, "A fire breaks out in the town livery. Before long, the surrounding buildings are engulfed in flame. The world falls into chaos.", "images/cards/34.png");
  trials.onCardRoles.add(new Role("Burning Man", 2, true, "Make it stop!", 20, 45));
  trials.onCardRoles.add(new Role("Cheese Vendor", 4, true, "Opa!", 83, 47));
  trials.onCardRoles.add(new Role("Hit with Table", 5, true, "Ow! A table?", 145, 47));
  sceneList.add(trials);

  Scene grinch = new Scene("How the Grinch Stole Texas", 5, "The doe-eyed citizens of El Paso gather together around a warm fire and pray for the safety of those poor souls in Oklahoma. It almost works.", "images/cards/35.png");
  grinch.onCardRoles.add(new Role("Detective", 3, true, "I have a hunch.", 20, 47));
  grinch.onCardRoles.add(new Role("File Clerk", 4, true, "My stapler!", 83, 47));
  grinch.onCardRoles.add(new Role("Cindy Lou", 5, true, "Dear Lord!", 145, 47));
  sceneList.add(grinch);

  Scene substance = new Scene("J. Robert Lucky, Man of Substance", 4, "Horace and Mathilde discover that the mysterious orange powder filling Doctor Lucky's air vents is neither Agent Orange nor weaponized Tang, but a rare form of cheese mold.", "images/cards/36.png");
  substance.onCardRoles.add(new Role("Man with Rope", 1, true, "Look out below!", 20, 47));
  substance.onCardRoles.add(new Role("Svetlana", 2, true, "Says who?", 83, 47));
  substance.onCardRoles.add(new Role("Accidental Victim", 5, true, "Ow! My spine!", 145, 47));
  sceneList.add(substance);

  Scene thirteen2 = new Scene("Thirteen the Hard Way", 5, "After operating for only six minutes, the Pony Express disbands and gives way to the international Telegraph and Railroad systems. Little boys cry.", "images/cards/37.png");
  thirteen2.onCardRoles.add(new Role("Very Wet Man", 2, true, "Sheesh!", 20, 47));
  thirteen2.onCardRoles.add(new Role("Dejected Housewife", 4, true, "Its time had come.", 83, 47));
  thirteen2.onCardRoles.add(new Role("Man with Box", 5, true, "Progress!", 145, 47));
  sceneList.add(thirteen2);


  Scene milk2 = new Scene("How They Get Milk", 4, "Josie is thoroughly off milk at this point. The Milkman shows her one more way that she might not have heard of before.", "images/cards/38.png");
  milk2.onCardRoles.add(new Role("Marksman", 4, true, "Pull!", 20, 47));
  milk2.onCardRoles.add(new Role("Postal Worker", 5, true, "It's about time!", 83, 47));
  milk2.onCardRoles.add(new Role("A Horse", 6, true, "Yes Sir!", 145, 47));
  sceneList.add(milk2);


  Scene trickPony = new Scene("Breakin' in Trick Ponies", 3, "Uncle Stewart reveals what to do when all else fails.", "images/cards/39.png");
  trickPony.onCardRoles.add(new Role("Fraternity Pledge", 2, true, "Beer me!", 53, 47));
  trickPony.onCardRoles.add(new Role("Man with Sword", 6, true, "None shall pass!", 115, 47));
  sceneList.add(trickPony);


  Scene custer = new Scene("Custer's Other Stands", 5, "General George Armstrong Custer clinches another victory at the battle of Little Sands. His trusty steed Cairo is not so lucky.", "images/cards/40.png");
  custer.onCardRoles.add(new Role("Farmer", 2, true, "Git off a that!", 20, 47));
  custer.onCardRoles.add(new Role("Exploding Horse", 4, true, "Boom!", 83, 47));
  custer.onCardRoles.add(new Role("Jack", 6, true, "Here we go again!", 145, 47));
  sceneList.add(custer);

  return sceneList;
  }
}
