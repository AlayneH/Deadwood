import java.util.*;

public class GameSets {
  static ArrayList<Location> setList = new ArrayList<Location>();

  public static ArrayList<Location> loadSets(){

    Location trainStation = new Location("Train Station", 3, 21, 69);
    trainStation.setShotCounters(141, 11, 89, 11, 36, 11);

    trainStation.neighborLocations.add("Jail");
    trainStation.neighborLocations.add("General Store");
    trainStation.neighborLocations.add("office");

    trainStation.offCardRoles.add(new Role("Crusty Prospector", 1, false, "Aww, peaches!", 114, 227));
    trainStation.offCardRoles.add(new Role("Dragged by Train", 1, false, "Omgeezers!", 51, 268));
    trainStation.offCardRoles.add(new Role("Preacher with Bag", 2, false, "The Lord will provide.", 114, 320));
    trainStation.offCardRoles.add(new Role("Cyrus the Gunfighter", 4, false, "Git to fightin' or git away!", 49, 356));

    setList.add(trainStation);


    Location secretHideout = new Location("Secret Hideout", 3, 27, 732);
    secretHideout.setShotCounters(354, 764, 299, 764, 244, 764);

    secretHideout.neighborLocations.add("Church");
    secretHideout.neighborLocations.add("Ranch");
    secretHideout.neighborLocations.add("office");

    secretHideout.offCardRoles.add(new Role("Clumsy Pit Fighter", 1, false, "Hit me!", 435, 719));
    secretHideout.offCardRoles.add(new Role("Thug with Knife", 2, false, "Meet Suzy, my murderin' knife.", 521, 719));
    secretHideout.offCardRoles.add(new Role("Dangerous Tom", 3, false, "There's two ways we can do this....", 435, 808));
    secretHideout.offCardRoles.add(new Role("Penny, who is lost", 4, false, "Oh, wow! for I am lost!", 521, 808));

    setList.add(secretHideout);


    Location church = new Location("Church", 2, 623, 734);
    church.setShotCounters(682, 675, 623, 675, 0, 0);

    church.neighborLocations.add("Secret Hideout");
    church.neighborLocations.add("Bank");
    church.neighborLocations.add("Hotel");

  	church.offCardRoles.add(new Role("Dead Man", 1, false, "....", 857, 730));
  	church.offCardRoles.add(new Role("Crying Woman", 2, false, "Oh, the humanity!", 858, 809));

    setList.add(church);


    Location hotel = new Location("Hotel", 3, 969, 740);
    hotel.setShotCounters(1111, 683, 1058, 683, 1005, 683);

    hotel.neighborLocations.add("trailer");
    hotel.neighborLocations.add("Jail");
    hotel.neighborLocations.add("Saloon");

    hotel.offCardRoles.add(new Role("Sleeping Drunkard", 1, false, "Zzzzzzz...Whiskey!", 1111, 469));
    hotel.offCardRoles.add(new Role("Faro Player", 1, false, "Hit me!", 1044, 509));
    hotel.offCardRoles.add(new Role("Falls from Balcony", 2, false, "Arrrgghh!", 1111, 557));
    hotel.offCardRoles.add(new Role("Australian Bartender", 3, false, "What'll it be, mate?", 1046, 596));

    setList.add(hotel);


  	Location mainStreet = new Location("Main Street", 3, 969, 28);
    mainStreet.setShotCounters(804, 16, 858, 16, 912, 16);

    mainStreet.neighborLocations.add("trailer");
    mainStreet.neighborLocations.add("Jail");
  	mainStreet.neighborLocations.add("Saloon");

    mainStreet.offCardRoles.add(new Role("Railroad Worker", 1, false, "Hit me!", 637, 22));
    mainStreet.offCardRoles.add(new Role("Falls off Roof", 2, false, "Aaaaiiiigggghh!", 720, 22));
    mainStreet.offCardRoles.add(new Role("Woman in Black Dress", 2, false, "Well, I'll be!", 637, 105));
    mainStreet.offCardRoles.add(new Role("Mayor McGinty", 4, false, "People of Deadwood!", 720, 105));

    setList.add(mainStreet);


    Location jail = new Location("Jail", 1, 281, 27);
    jail.setShotCounters(442, 156, 0, 0, 0, 0);

    jail.neighborLocations.add("Main Street");
    jail.neighborLocations.add("General Store");
    jail.neighborLocations.add("Train Station");

    jail.offCardRoles.add(new Role("Prisoner In Cell", 2, false, "Zzzzzzz...Whiskey!", 519, 25));
    jail.offCardRoles.add(new Role("Feller in Irons", 3, false, "Ah kilt the wrong man!", 519, 105));

    setList.add(jail);


    Location generalStore = new Location("General Store", 2, 370, 282);
    generalStore.setShotCounters(313, 330, 313, 277, 0, 0);

    generalStore.neighborLocations.add("Ranch");
    generalStore.neighborLocations.add("Train Station");
    generalStore.neighborLocations.add("Jail");
    generalStore.neighborLocations.add("Saloon");

  	generalStore.offCardRoles.add(new Role("Man in Overalls", 1, false, "Looks like a storm's comin' in.", 236, 276));
  	generalStore.offCardRoles.add(new Role("Mister Keach", 3, false, "Howdy, stranger.", 236, 358));

    setList.add(generalStore);


    Location ranch = new Location("Ranch", 2, 252, 478);
    ranch.setShotCounters(525, 473, 472, 473, 0, 0);

    ranch.neighborLocations.add("office");
    ranch.neighborLocations.add("General Store");
    ranch.neighborLocations.add("Secret Hideout");
    ranch.neighborLocations.add("Bank");

    ranch.offCardRoles.add(new Role("Shot in Leg", 1, false, "Ow! Me Leg!", 412, 608));
    ranch.offCardRoles.add(new Role("Saucy Fred", 2, false, "That's what she said.", 488, 608));
    ranch.offCardRoles.add(new Role("Man Under Horse", 3, false, "A little help here!", 488, 525));

    setList.add(ranch);


    Location bank = new Location("Bank", 1, 623, 475);
    bank.setShotCounters(840, 549, 0, 0, 0, 0);

    bank.neighborLocations.add("Saloon");
    bank.neighborLocations.add("Church");
    bank.neighborLocations.add("Ranch");
    bank.neighborLocations.add("Hotel");

    bank.offCardRoles.add(new Role("Suspicious Gentleman", 2, false, "Can you be more specific?", 911, 554));
    bank.offCardRoles.add(new Role("Flustered Teller", 3, false, "Would you like a large bill, sir?", 911, 470));

    setList.add(bank);


    Location saloon = new Location("Saloon", 2, 632, 280);
    saloon.setShotCounters(679, 216, 626, 216, 0, 0);

    saloon.neighborLocations.add("Main Street");
    saloon.neighborLocations.add("General Store");
    saloon.neighborLocations.add("Bank");
    saloon.neighborLocations.add("trailer");

  	saloon.offCardRoles.add(new Role("Reluctant Farmer", 1, false, "I ain't so sure about that!", 877, 352));
    saloon.offCardRoles.add(new Role("Woman in Red Dress", 2, false, "Come up and see me!", 877, 276));

    setList.add(saloon);


    Location trailer = new Location("trailer", 0, 991, 248);

    trailer.neighborLocations.add("Main Street");
    trailer.neighborLocations.add("Saloon");
    trailer.neighborLocations.add("Hotel");

    setList.add(trailer);


    Location office = new Location("office", 0, 9, 459);

    office.neighborLocations.add("Train Station");
    office.neighborLocations.add("Ranch");
    office.neighborLocations.add("Secret Hideout");

    setList.add(office);

    return setList;
  }

}
