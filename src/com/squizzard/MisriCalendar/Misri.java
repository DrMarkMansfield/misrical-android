package com.squizzard.MisriCalendar;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;


public class Misri {
	static final Map<Integer, String[]> eventMap= new TreeMap<Integer, String[]>();
	static final Map<Integer, String[]> priorityEventMap= new TreeMap<Integer, String[]>();
	static{

		eventMap.put(new Integer(1), new String[]{"Urus Mawlai Abdullah Saheb Khambat"});
		eventMap.put(new Integer(2), new String[]{"Urus Syedi Shaikh Pir Jamaluddin Jamnagar","Urus Syedi Khanji Fir Saheb Udaipur","Urus Mawlai Raj Bin Mawlai Hasan Saheb Ahmedabad"});
		eventMap.put(new Integer(6), new String[]{"Urus Syedi Mohammed Bin Qazikhan Kapadvanj"});
		eventMap.put(new Integer(7), new String[]{"Urus Syedna Ismail Badruddin AQ [38th Dai] Jamnagar"});
		eventMap.put(new Integer(10), new String[]{"Urus Syedna Zoeb Bin Musa AQ [1st Dai] Yemen","Urus Mawlai Ahmed Saheb Khambat"});
		priorityEventMap.put(new Integer(10), new String[]{"Yawme Ashura"});
		eventMap.put(new Integer(14), new String[]{"Urus Mawlai Lukmanji Mulla Alibhai Saheb Wankaner"});
		eventMap.put(new Integer(15), new String[]{"Urus Mawlai Nuruddin Saheb Dongaon"});
		priorityEventMap.put(new Integer(16), new String[]{"Urus Syedna Hatim bin Syedna Ibrahim AQ [3rd Dai] Yemen"});
		priorityEventMap.put(new Integer(17), new String[]{"Urus Shahadat Imam Ali Zainulabedin SA Medina"});	
		eventMap.put(new Integer(17), new String[]{"Urus Syedna Ibrahim Vajihuddin AQ [39th Dai] Ujain","Urus Mulla Mohammedali bin Syedi Najam Khan Pune", "Urus Mawlai Masud bin Sulaiman Dhrangadhra","Urus Seven Shahid Sahebo Mujpur"});
		eventMap.put(new Integer(18), new String[]{"Urus Shahid Gani Pir Ibne Dawoodji Kalavad"});
		eventMap.put(new Integer(23), new String[]{"Urus Syedi Hasan Fir Saheb Shahid Denmal", "Urus Noor Bibi Umme Syedna Yusuf Najmuddin Dandigam", "Urus Fatema Bibi Ukhte Syedna Yusuf Najmuddin Dandigam"});
		eventMap.put(new Integer(24), new String[]{"Urus Syedi Dada Sulemanji Bundi, Kota"});
		priorityEventMap.put(new Integer(27), new String[]{"Urus Syedi Fakhruddin Shahid AQ Taherabad (Galiakot)"});
		eventMap.put(new Integer(28), new String[]{"Urus Syedi Musaji bin Taj Baroda"});
		eventMap.put(new Integer(29), new String[]{"Urus Mawlai Hasan Bin Mawlai Adam Ahmedabad"});
		eventMap.put(new Integer(31), new String[]{"Urus Syedna Ali Bin Syedna Husain AQ [10th Dai] Yemen"});
		eventMap.put(new Integer(33), new String[]{"Urus Syedna Ali Shamsuddin Bin Syedna Abdullah AQ [18th Dai] Yemen"});
		eventMap.put(new Integer(34), new String[]{"Urus Syedna Abdul Tayyib Zakiyuddin AQ [41st Dai] Burhanpur"});
		eventMap.put(new Integer(36), new String[]{"Urus Syedi Abdeali Imaduddin Surat"});
		eventMap.put(new Integer(38), new String[]{"Urus Syedna Khattab Bin Hasan Hamdani AQ Yemen"});
		eventMap.put(new Integer(39), new String[]{"Urus Syedi Tayyib bs Zainuddin Surat"});
		eventMap.put(new Integer(42), new String[]{"Urus Syedna Ahmed Hamiduddin Kirmani RA Cairo"});
		eventMap.put(new Integer(43), new String[]{"Urus Mawlai Adam bin Sulaimanji Ahmedabad"});
		eventMap.put(new Integer(44), new String[]{"Urus Kaka Akela - Kaki Akeli Khambat", "Urus Mawlai Noorbhai Saheb Dhinoj"});
		eventMap.put(new Integer(45), new String[]{"Urus Syedi Hamza Bhaisaheb Surat"});
		eventMap.put(new Integer(47), new String[]{"Urus Shaikh AbdulHusain Shahid Chechat","Urus Mawlai Shaikh Saheb bin Sulaimanji","Urus Syedi Shaikh Ibrahim Chechat"});
		priorityEventMap.put(new Integer(50), new String[]{"Chelum Imam Husain SA"});
		eventMap.put(new Integer(52), new String[]{"Urus Syedna Husain bin Syedna Ali AQ [8th Dai] Yemen"});
		eventMap.put(new Integer(57), new String[]{"Urus Syedna Mohammed Izzuddin AQ [23rd Dai] Yemen"});
		priorityEventMap.put(new Integer(58), new String[]{"Shahadat Imam Hasan SA"});
		eventMap.put(new Integer(59), new String[]{"Urus Syedi Hasan Zakiyuddin Surat"});
		eventMap.put(new Integer(60), new String[]{"Urus Syedi Shaikh Adam Safiyuddin Jamnagar","Urus Syedi Jamaluddin bin Shaikh Adam Jamnagar"});
		eventMap.put(new Integer(61), new String[]{"Urus Syedna Abdul Tayyib Zakiyuddin bin Syedna Dawood bin Qutbub  Shah AQ [29th Dai] Ahmedabad"});
		eventMap.put(new Integer(63), new String[]{"Urus Syedi Habibullah bin Mulla Adamji Ujjain"});
		eventMap.put(new Integer(66), new String[]{"Urus Syedi Shaikh Dawood Bhai Mulla Mehmoodji Udaipur","Urus Syedi Abdeali Mohyiddin Surat"});
		eventMap.put(new Integer(69), new String[]{"Urus Syedna Abdullah Badruddin AQ [50th Dai] Surat"});
		priorityEventMap.put(new Integer(71), new String[]{"Milad Eid Milad un Nabi"});
		eventMap.put(new Integer(71), new String[]{"Urus Ummul Mumineen Amatullah Aaisaheba London"});
		eventMap.put(new Integer(73), new String[]{"Urus Syedi Miaji Mulla Taj Saheb Amaryaath"});
		eventMap.put(new Integer(81), new String[]{"Urus Syedna Ali bin Hanzala AQ [6th Dai] Yemen","Urus Mawlai Dawood bin Raj Saheb Morbi"});
		eventMap.put(new Integer(82), new String[]{"Urus Syedi Qazi Khan bin Ameen Shah Halwad","Urus Mawlai Raj Saheb Morbi"});
		eventMap.put(new Integer(84), new String[]{"Urus Syedna Ali Shamsuddin bin Mawlai Hasan [30th Dai] Yemen"});
		eventMap.put(new Integer(87), new String[]{"Urus Mohammad bin Hasan Saheb Dhinoj"});

		priorityEventMap.put(new Integer(93), new String[]{"Milad Imam uz Zaman"});
		eventMap.put(new Integer(94), new String[]{"Urus Mia Saheb Maati Bhai Mulla Noor Bhai Balasinor","Urus Mia Saheb Tayebji Shaikh Shams Khan Balasnwar"});
		eventMap.put(new Integer(97), new String[]{"Urus Mawlai Raj bin Mulla Adam Saheb Jamnagar"});
		eventMap.put(new Integer(99), new String[]{"Urus Syedi AbdulRasul Shahid Baanswara"});
		eventMap.put(new Integer(103), new String[]{"Urus Syedi Ismailji Shahid bin Abde Musa Godhra"});
		eventMap.put(new Integer(105), new String[]{"Urus Syedna Jalal Shamsuddin AQ bin Hasan [25th Dai] Ahmedabad"});
		priorityEventMap.put(new Integer(109), new String[]{"Milad Dai Uz Zaman Syedna Mohammed Burhanuddin (TUS)"});
		eventMap.put(new Integer(111), new String[]{"Urus Syedna Musa Kalimuddin bin Syedna Abdul Tayyib Zakiyuddin AQ [36th Dai] Jamnagar","Urus Syedi Mulla Habibullah bin Shaikh Sultanali Bharuch"});
		eventMap.put(new Integer(116), new String[]{"Urus Syedna Dawood Burhanuddin AQ bin Ajab Shah [26th Dai] Ahmedabad"});
		eventMap.put(new Integer(117), new String[]{"Urus Kakaji Mulla Isa Bhai Partapghar"});
		eventMap.put(new Integer(118), new String[]{"Salgirah Syedi Mazoon Saheb Khuzaima Bhaisaheb Qutbuddin"});

		eventMap.put(new Integer(119), new String[]{"Urus Syedna Ahmed Al Mukaraam Yemen"});
		eventMap.put(new Integer(121), new String[]{"Urus Syedi Qazi Khan bin Ali Sidhpur"});
		eventMap.put(new Integer(126), new String[]{"Urus Syedi Mulla Wahid Bhaisaheb bin Mulla Ibrahimji Surat"});
		priorityEventMap.put(new Integer(128), new String[]{"Wafat Maulatena Fatema tuz Zahra"});
		eventMap.put(new Integer(129), new String[]{"Urus Mawlai Nooruddin Saheb Dongaon"});
		eventMap.put(new Integer(133), new String[]{"Urus Mawlai Dawood bin Qazi Ahmed Dongaon"});
		eventMap.put(new Integer(135), new String[]{"Urus Syedi Dawood Bhaisaheb Shihabuddin Surat"});
		eventMap.put(new Integer(139), new String[]{"Urus Seth Chanda bhai ibne Karim Bhai Mumbai"});
		eventMap.put(new Integer(141), new String[]{"Urus Mulla Jaferji Jiwaji Amreli"});
		eventMap.put(new Integer(147), new String[]{"Urus Syedi Jivanji bin Shaikh Dawood Bhaisaheb Burhanpur"});

		eventMap.put(new Integer(156), new String[]{"Urus Syedi Luqmaanji bin Mulla Habibullah Surat"});
		eventMap.put(new Integer(160), new String[]{"Urus Mulla Tayyib Bawa bin Mulla Ibrahimji Ranala"});
		eventMap.put(new Integer(162), new String[]{"Urus Ganje Shohoda Ahmednagar"});
		eventMap.put(new Integer(163), new String[]{"Urus Syedna Dawood Burhanuddin AQ bin Qutub Shah [27th Dai] Ahmedabad","Urus Mawlai Ali bhai Shahid (Indore) Kamlapur"});
		eventMap.put(new Integer(166), new String[]{"Urus Syedna Yusuf Najmuddin AQ [42nd Dai] Surat","Urus Moulai Burhanuddin Ibne Khoj Khan Pisawada","Urus Mawlai Adam ibne Dawood Jamnagar"});
		priorityEventMap.put(new Integer(171), new String[]{"Urus Syedna Ismail Badruddin AQ bin Mawlai Raj [34th Dai] Jamnagar"});
		eventMap.put(new Integer(174), new String[]{"Salgirah Syedi Mukasir Saheb Husain Bhaisaheb Husamuddin"});
		eventMap.put(new Integer(175), new String[]{"Urus Syedna Lamak bin Malik RA Lahab (Yemen)"});
		priorityEventMap.put(new Integer(175), new String[]{"Urus Syedna Qutub Khan Qutubuddin Shahid AQ [32nd Dai] Ahmedabad"});
		eventMap.put(new Integer(176), new String[]{"Urus Syedna Ahmed bin Mubarak AQ (Hamdaan) [7th Dai] Yemen","Urus Syedna Yahya bin Syedna Lamak AQ Lahab (Yemen)"});
		eventMap.put(new Integer(177), new String[]{"Urus Syedna Qadi Numan bin Mohammed AQ Misr","Urus Syedna Mohammed Badruddin AQ [46th Dai] Surat","Urus Ajab Busaheba Binte Syedna Qutubuddin Shahid AQ Ahmedabad"});
		priorityEventMap.put(new Integer(177), new String[]{"Washeq Raat Pehli Raat Washeq"});

		priorityEventMap.put(new Integer(178), new String[]{"Rozu"});
		eventMap.put(new Integer(179), new String[]{"Urus Bhaiji Bhai Ibne Qazi Bhai Karachi","Urus Mawlai Raj bin Dawood Ahmedabad"});
		priorityEventMap.put(new Integer(181), new String[]{"Urus Syedna Noor Mohammed Nooruddin AQ [37th Dai] Kutch Mandvi"});
		eventMap.put(new Integer(181), new String[]{"Urus Syedi Hasanji Badshah Ujjain"});
		eventMap.put(new Integer(184), new String[]{"Urus Syedna Shaikh Adam Safiyuddin AQ [28th Dai] Ahmedabad"});
		eventMap.put(new Integer(185), new String[]{"Urus Syedi Saifuddin Saheb Jamnagar"});
		eventMap.put(new Integer(189), new String[]{"Urus Syedi Najam Khan bin Syedna Fir Khan Shujahuddin AQ Aurangabad"});
		priorityEventMap.put(new Integer(190), new String[]{"Ayyam ul Biz Rozu"});
		eventMap.put(new Integer(190), new String[]{"Milad Amirul Mumineen, Maulana Ali (SA)"});
		priorityEventMap.put(new Integer(191), new String[]{"Ayyam ul Biz Rozu"});
		eventMap.put(new Integer(191), new String[]{"Urus Mawlai Yaqub Saheb Paatan"});
		priorityEventMap.put(new Integer(192), new String[]{"Ayyam ul Biz & Salaat uz-Zawal Rozu"});
		eventMap.put(new Integer(195), new String[]{"Urus Syedna Ali Shamsuddin AQ bin Syedna Ibrahim bin Husain AQ [13th Dai] Yemen Zamarmar"});
		priorityEventMap.put(new Integer(196), new String[]{"Urus Syedna Taher Saifuddin AQ [51st Dai] Mumbai"});
		eventMap.put(new Integer(201), new String[]{"Urus Syedna Abdul Mutalib Najmuddin AQ bin Syedna Mohammed bin Hatim AQ [14th Dai] Yemen Zamarmar","Urus Syedi Qamruddin Bhaisaheb bin Syedna Haibatullah Al Muaid AQ Ujjain"});
		priorityEventMap.put(new Integer(203), new String[]{"Urus Syedna Abdul Qadr Najmuddin AQ [47th Dai] Ujjain","Laylat ul-Meraj Washeq Raat"});
		priorityEventMap.put(new Integer(204), new String[]{"Yawm al-Mabath (Motius Sawalat) Rozu"});
		eventMap.put(new Integer(204), new String[]{"Urus Syedi Miasaheb Alibhai bin Peeriji Radhanpur","Urus Aminji Shahid [Urus done on the 24th] Paddhari"});
		eventMap.put(new Integer(206), new String[]{"Urus Syedi Luqmaanji bin Syedi Dawood bhai Udaipur"});

		eventMap.put(new Integer(208), new String[]{"Urus Syedna Hebatullah Muayyad Fiddin AQ [40th Dai] Ujjain"});
		priorityEventMap.put(new Integer(221), new String[]{"Washeq Raat Shabb-e-Baraat"});
		priorityEventMap.put(new Integer(222), new String[]{"Urus Syedna Hasan Badruddin AQ [20th Dai] Yemen Masaar"});
		eventMap.put(new Integer(223), new String[]{"Urus Syedna Ibrahim bin Husain AQ [2nd Dai] Yemen Hamdaan"});
		eventMap.put(new Integer(226), new String[]{"Urus Syedi Saleh bhaisaheb Saifuddin Mumbai"});
		priorityEventMap.put(new Integer(229), new String[]{"Urus Maulatina Hurratul Malika (RA) Sanaa, Yemen"});
		eventMap.put(new Integer(229), new String[]{"Urus Syedi Shaikhfir bin Dawood Shahid Ranpur","Urus Syedi Shaikh Valibhai bin Shaikh Habibullah Urus on 2nd of Ramadan, recited on 22nd Shaban Paarda"});
		eventMap.put(new Integer(232), new String[]{"Urus Syedi Shams Khan bin Syedi Yusufji Surat"});
		eventMap.put(new Integer(236), new String[]{"Urus Syedna Ali bin Mawla Mohammed al-Walid AQ [5th Dai] Yemen","Urus Syedi Jiwanji bin Shaikh Dawood bhai Burhanpur"});

		eventMap.put(new Integer(237), new String[]{"Urus Shaikh Dawood Bhaisaheb Dhinoj"});
		eventMap.put(new Integer(238), new String[]{"Urus Syedi Wali Bhaisaheb bin Syedi Habibullah Pardha"});
		eventMap.put(new Integer(240), new String[]{"Urus Syedi Tayyib Bhaisaheb Zainuddin AQ Surat"});
		eventMap.put(new Integer(244), new String[]{"Urus Syedi Fazal Bhaisaheb Qutubuddin bin Syedna Abdullah AQ Surat"});
		eventMap.put(new Integer(245), new String[]{"Urus Syedna Abdullah Fakhruddin AQ bin Ali [16th Dai] Yemen"});
		priorityEventMap.put(new Integer(252), new String[]{"Washeq Raat"});
		eventMap.put(new Integer(252), new String[]{"Urus Syedi Hebatullah Jamaluddin Jamnagar"});
		priorityEventMap.put(new Integer(254), new String[]{"Washeq Raat"});
		priorityEventMap.put(new Integer(255), new String[]{"Shahadat Amir ul Mumineen, Maulana Ali SA"});
		eventMap.put(new Integer(255), new String[]{"Urus Syedna Mohammed Izziuddin AQ bin Syedi Jiwanji [44th Dai] Surat"});
		priorityEventMap.put(new Integer(256), new String[]{"Washeq Raat"});
		priorityEventMap.put(new Integer(257), new String[]{"Wafaat Amir ul Mumineen, Maulana Ali SA"});
		priorityEventMap.put(new Integer(258), new String[]{"Laylatul Qadr Laylatul Qadr"});
		priorityEventMap.put(new Integer(265), new String[]{"Washeq Raat"});
		priorityEventMap.put(new Integer(266), new String[]{"Laylatul Eid ul Fitr Takbira, Washeq Raat"});

		priorityEventMap.put(new Integer(267), new String[]{"Eid ul Fitr Takbira (Fajr, Zohar)"});
		eventMap.put(new Integer(269), new String[]{"Urus Shehzadi Sakina Bhensaheba binte Syedna Taher Saifuddin AQ Mumbai"});
		eventMap.put(new Integer(270), new String[]{"Urus Syedi Yusufji Ahmedabad","Urus Syedi Taiyebji Shahid Ahmedabad","Urus Syedi Abdul Qadir Hakimuddin [First Urus] Burhanpur"});
		eventMap.put(new Integer(272), new String[]{"Urus Syedna Hasan Badruddin bin Syedba Abdullah Fakhruddin AQ [17th Dai] Yemen"});
		eventMap.put(new Integer(273), new String[]{"Urus Syedna Mohammed bin Taher AQ [Writer of Dua Al Aql Al Awwal, Bawesani Dua] Yemen"});
		eventMap.put(new Integer(274), new String[]{"Urus Syedna Abbas bin Syedna Mohammed bin Hatim AQ [15th Dai] Yemen"});
		eventMap.put(new Integer(275), new String[]{"Urus Syedna Qasim Khan Zainuddin AQ [31st Dai] Ahmedabad"});
		eventMap.put(new Integer(276), new String[]{"Urus Syedna Hebatullah Muayyadfiddin Shirazi AQ Cairo","Urus Syedna Husain Husamuddin AQ [21st Dai] Yemen","Urus Syedna Ibrahim bin Syedna Husain AQ [11th Dai] Yemen"});
		eventMap.put(new Integer(279), new String[]{"Urus Syedi Aminji bin Jalal Ahmedabad"});
		eventMap.put(new Integer(290), new String[]{"Urus Shaikh Qutub Bhai bin Sulaimanji Pune"});
		priorityEventMap.put(new Integer(293), new String[]{"Urus Syedi Abdul Qadir Hakimuddin [Second Urus] Burhanpur"});
		eventMap.put(new Integer(293), new String[]{"Urus Mia Saheb Abdeali Waliullah Jaawarah"});
		eventMap.put(new Integer(295), new String[]{"Urus Mulla Salehbhai Ibne Najamkhan Ahmedabad","Urus Syedi Bawa Mulla Khan Saheb bin Syedi Habibullah Rampurah","Urus Syedi Qasim Khan bin Hamza Bhai Surat"});


		eventMap.put(new Integer(304), new String[]{"Urus Syedna Fir Khan Shujahuddin AQ [33rd Dai] Ahmedabad"});
		eventMap.put(new Integer(306), new String[]{"Urus Syedi Hasan bin Nuh Bharuji Yemen, Masaar","Urus Syedna Ali bin Mohammed Sulayhi RA Yemen"});
		eventMap.put(new Integer(307), new String[]{"Urus Syedna Abdul Tayyib Zakiyuddin bin Syedna Ismail Badruddin AQ  [35th Dai] Jamnagar"});
		priorityEventMap.put(new Integer(307), new String[]{"Urus Syedna Abdeali Saifuddin AQ [43rd Dai] Surat"});
		eventMap.put(new Integer(308), new String[]{"Urus Syedna Ali bin Syedna Husain [9th Dai] Yemen"});
		eventMap.put(new Integer(310), new String[]{"Urus Syedna Tayyib Zainuddin bin Syedi Jewanji [45th Dai] Surat","Urus Bai Saheba Raani Baisaheba binte Syedna Ismail Badruddin AQ Mundra"});
		eventMap.put(new Integer(314), new String[]{"Urus Syedna Idris Imaduddin AQ [19th Dai] Yemen, Shaam"});
		eventMap.put(new Integer(316), new String[]{"Urus Syedna Ali Shamsuddin AQ [22nd Dai] Yemen"});
		eventMap.put(new Integer(317), new String[]{"Urus Syedi Shaikh Sadiq Ali Saheb Surat"});
		eventMap.put(new Integer(320), new String[]{"Urus Syedna Ali Shamsuddin bin Syedna Hatim AQ [4th Dai] Yemen"});
		eventMap.put(new Integer(322), new String[]{"Urus Syedi Yusuf Khan bin Syedi Shams Khan Shajapur"});
		priorityEventMap.put(new Integer(322), new String[]{"Milad Syedna Taher Saifuddin AQ [51st Dai]"});

		eventMap.put(new Integer(326), new String[]{"Urus Syedna Mohammed AQ bin Hatim bin Husain in Ali [12th Dai] Yemen"});
		eventMap.put(new Integer(331), new String[]{"Urus Syedi Khoj bin Malak Kaparwanj"});
		priorityEventMap.put(new Integer(334), new String[]{"Yawm ul-Arafa Takbira and Washeq"});
		priorityEventMap.put(new Integer(335), new String[]{"Eid al Adha Takbira"});
		priorityEventMap.put(new Integer(336), new String[]{"Takbira"});
		priorityEventMap.put(new Integer(337), new String[]{"Takbira"});
		priorityEventMap.put(new Integer(338), new String[]{"Takbira"});
		eventMap.put(new Integer(338), new String[]{"Urus Mawlai Feroz bin Ismail Ahmedabad"});
		eventMap.put(new Integer(340), new String[]{"Bu saheba, Amatullah Aai saheba Milad"});
		eventMap.put(new Integer(341), new String[]{"Urus Syedna Yusuf Najmuddin bin Sulaiman AQ [24th Dai] Taybah, Yemen","Urus Syedi Ishaq Bhaishaeb Jamaluddin AQ Mumbai"});
		priorityEventMap.put(new Integer(343), new String[]{"Eid e Gadhir e Khum Rozu"});
		eventMap.put(new Integer(352), new String[]{"Urus Syedna Abdul Husain Husamuddin bin Syedna Tayyib Zainuddin AQ [48th Dai] Ahmedabad","Urus Syedna Mohammed Burhanuddin bin Syedna AbdulQadir Najmuddin AQ [49th Dai] Surat"});
		eventMap.put(new Integer(354), new String[]{"Urus Ghanj Shuhada Ahmednagar"});

	}

	static final int gregorian_century [][]= {{600,0},{700,36525},{800,73050},{900,109575},{1000,146100},{1100,182625},{1200,219150},{1300,255675},
		{1400,292200},{1500,328725},{1582,358665},{1600,365240},{1700,401764},{1800,438288},{1900,474812},{2000,511337}};

	static final int gregorian_decade [][]= {{4,1461},{8,2922},{12,4383},{16,5844},{20,7305},{24,8766},{28,10227},{32,11688},
		{36,13149},{40,14610},{44,16071},{48,17532},{52,18993},{56,20454},{60,21915},{64,23376},
		{68,24837},{72,26298},{76,27759},{80,29220},{84,30681},{88,32142},{92,33603},{96,35064}};

	static final int gregorian_month[][] = {{1,0,366,731,1096},{2,31,397,762,1127},{3,60,425,790,1155},{4,91,456,821,1186},
		{5,121,486,851,1216},{6,152,517,882,1247},{7,182,547,912,1277},{8,213,578,943,1308},
		{9,244,609,974,1339},{10,274,639,1004,1369},{11,305,670,1035,1400},{12,335,700,1065,1430}};

	static final int misri_cycle_30[][] = {{0,8231},{30,18862},{60,29493},{90,40124},{120,50755},{150,61386},{180,72017},{210,82648},{240,93279},{270,103910},
		{300,114541},{330,125172},{360,135803},{390,146434},{420,157065},{450,167696},{480,178327},{510,188958},{540,199589},{570,210220},
		{600,220851},{630,231482},{660,242113},{690,252744},{720,263375},{750,274006},{780,284637},{810,295268},{840,305899},{870,316530},
		{900,327161},{930,337792},{960,348423},{990,359054},{1020,369685},{1050,380316},{1080,390947},{1110,401578},{1140,412209},
		{1170,422840},{1200,433471},{1230,444102},{1260,454733},{1290,465364},{1320,475995},{1350,486626},{1380,497257},{1410,507888},{1440,518519},
		{1470,529150},{1500,539781}};

	static final int misri_year[][] = {{1,0},{2,354},{3,709},{4,1063},{5,1417},{6,1772},{7,2126},{8,2480},{9,2835},{10,3189},
		{11,3544},{12,3898},{13,4252},{14,4607},{15,4961},{16,5315},{17,5670},{18,6024},{19,6378},{20,6733},
		{21,7087},{22,7442},{23,7796},{24,8150},{25,8505},{26,8859},{27,9213},{28,9568},{29,9922},{30,10277}};

	static final int misri_month[] = {0,30,59,89,118,148,177,207,236,266,295,325};


	boolean isTodayPriorityMiqaat = false;
	private int todayMisriOrdinal = 0;
	private String todayEvent;
	Calendar c;// = Calendar.getInstance(); V1.01
    private int todayMisriDay;
    private String todayMisriMonth;
    private int todayMisriMonthCode;
    private int todayMisriYear;
    private int convertedGregorianDay;
    private int convertedGregorianYear;
    private int convertedGregorianMonth;
    
    public Misri(){
    	getTodayMisri();
    }
	
	
	public boolean isTodayPriorityMiqaat(){
		return isTodayPriorityMiqaat;
	}

	public int getMisriOrdinal(){
		return todayMisriOrdinal;
	}

	public String getTodayMisri()//called by the widget
	{
		c=Calendar.getInstance();//V1.01
		return getMisriDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
	}
	
	public CharSequence getTomorrowMisri() {
		c=Calendar.getInstance();//V1.01
		c.add(Calendar.DATE, 1);
		return getMisriDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
	}

	public String getTodayGregorian(){//called by the widget
		c=Calendar.getInstance();//V1.01
		return convertGregorian(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
	}

	public String getGregorianDate(int misriY, int misriM, int misriD) {
		// find the number smaller than the year in misri_cycle_30
		int diff=0;
		int ord30=0;
		for(int j=0;j<misri_cycle_30.length; j++){
			if(misri_cycle_30[j][0]>=misriY){
				ord30=misri_cycle_30[j-1][1];
				diff = misriY-misri_cycle_30[j-1][0];
				break;
			}
		}
		int gregorianOrdinal = misri_month[misriM] + ord30 + misriD + misri_year[diff-1][1];

		//Convert gregorianOrdinal to a readable date
		int gregorianCentury = 0;
		for(int j=0;j<gregorian_century.length;j++){
			if(gregorian_century[j][1]>=gregorianOrdinal){
				gregorianCentury=gregorian_century[j-1][0];
				diff=gregorianOrdinal-gregorian_century[j-1][1];
				break;
			}
		}
		//V1.02 If after year 2000 then use final entry
		if((gregorianCentury == 0) && (gregorianOrdinal>511337)){
			gregorianCentury=gregorian_century[gregorian_century.length-1][0];
			diff=gregorianOrdinal-gregorian_century[gregorian_century.length-1][1];
		}

		int gregorianYear=0;
		int spareYears=0;
		for(int j=0;j<gregorian_decade.length;j++){
			if(gregorian_decade[j][1]>=diff){
				if(j==0){
					gregorianYear=gregorianCentury;
					spareYears=diff;
					break;
				}
				gregorianYear=gregorian_decade[j-1][0]+gregorianCentury;
				spareYears=diff-gregorian_decade[j-1][1];
				break;
			}
		}
		if((spareYears==0)&& (diff>35064)){
			gregorianYear = 96 + gregorianCentury;
			spareYears = diff-35064;
		}
		//look for spareYears in gregorianMonth
		int gMonth=-1;
		int gDay=-1;
		for(int j=0;j<gregorian_month.length;j++){
			if(gregorian_month[j][1]>=spareYears){
				if(j==0){//if spareYers=0 then dec31
					gMonth=gregorian_month[11][0];//dec
					gDay = 31;
					gregorianYear-=1;//go to the previous year
					break;
				}
				gMonth=gregorian_month[j-1][0];
				gDay=spareYears-gregorian_month[j-1][1];//this could generate the 0th
				break;//breaks out of the for loop
			}
		}
		if(gMonth==-1){//implying a greater number hasn't been found in the first column
			for(int j=0;j<gregorian_month.length;j++){
				if(gregorian_month[j][2]>=spareYears){
					if(j==0){//spreYrs=366
						gMonth=gregorian_month[11][0];//dec
						gDay=spareYears-gregorian_month[11][1];
						break;
					}
					gMonth=gregorian_month[j-1][0];
					gDay=spareYears-gregorian_month[j-1][2];
					gregorianYear+=1;
					break;//breaks out of the for loop
				}
			}
		}
		if(gMonth==-1){//implying a greater number hasn't been found in the first or second column
			for(int j=0;j<gregorian_month.length;j++){
				if(gregorian_month[j][3]>=spareYears){
					if(j==0){
						gMonth=gregorian_month[11][0];
						gDay=spareYears-gregorian_month[11][2];
						gregorianYear+=1;
						break;
					}
					gMonth=gregorian_month[j-1][0];
					gDay=spareYears-gregorian_month[j-1][3];
					gregorianYear+=2;
					break;//breaks out of the for loop
				}
			}
		}
		if(gMonth==-1){//implying a greater number hasn't been found in the first or second column
			for(int j=0;j<gregorian_month.length;j++){
				if(gregorian_month[j][4]>=spareYears){
					if(j==0){
						gMonth=gregorian_month[11][0];
						gDay=spareYears-gregorian_month[11][3];
						gregorianYear+=2;
						break;
					}
					gMonth=gregorian_month[j-1][0];
					gDay=spareYears-gregorian_month[j-1][4];
					gregorianYear+=3;
					break;//breaks out of the for loop
				}
			}
		}
		if(gMonth==-1&&spareYears<=1461){ 
			gMonth = 12;//Accounting for Table 2 Stage 3 1430->1461
			gDay = spareYears-1430;
			gregorianYear+=3;
		}
		setConvertedGregorianDay(gDay);
		setConvertedGregorianMonth(gMonth-1);
		setConvertedGregorianYear(gregorianYear);
			
		return convertGregorian(gDay, gMonth-1, gregorianYear);
	}

	public String getMisriDate(int y, int m, int d){
		String misriDate = null;
		int month = -1;
		int misriYear = -1;
		int monthDay = -1;
		int cycle30Diff = -1;
		int yearDiff = -1;

		int gregorianOrdinal = getGregorianAsOrdinal(y, m, d);
		for(int j=0;j<misri_cycle_30.length; j++){
			if(misri_cycle_30[j][1]>=gregorianOrdinal){
				try{
				misriYear=misri_cycle_30[j-1][0];
				}catch(ArrayIndexOutOfBoundsException e){
					return "Out of calendar range!";
				}
				cycle30Diff = gregorianOrdinal-misri_cycle_30[j-1][1];
				break;
			}
		}
		for(int j=0;j<misri_year.length;j++){
			if(misri_year[j][1]>=cycle30Diff){
				try{
				misriYear=misriYear+misri_year[j-1][0];
				yearDiff = cycle30Diff-misri_year[j-1][1];
				}catch(ArrayIndexOutOfBoundsException e){
					return "Out of calendar range!";
				}
				break;
			}
		}
		if((yearDiff==-1) && (cycle30Diff>10277)){ //V1.01
			misriYear=misriYear+misri_year[29][0];
			yearDiff = cycle30Diff-misri_year[29][1];
		}
		//using yearDiff find the exact date in the year from misri_month
		for(int j=0;j<misri_month.length;j++){
			if(misri_month[j]>=yearDiff){
				month = j;
				monthDay = yearDiff-misri_month[j-1];
				break;
			}
		}

		if((month==-1) && (yearDiff>325) && (yearDiff <=355)){//V1.01 - changed from 354 to 355
			month=12;
			monthDay = yearDiff-misri_month[11];
		}

		//format this to a string for display
		misriDate = convertMisri(monthDay, month, misriYear);
		setTodayMisriDay(monthDay);
		setTodayMisriMonth(getMisriMonth(month));
		setTodayMisriMonthCode(month);
		setTodayMisriYear(misriYear);
		setEvent(month, monthDay);
		return misriDate;
	}

	private int getGregorianAsOrdinal(int year, int month, int day){
		int ordinal=0;
		int century = year-(year%100);
		int decade = year%100;
		int spareYears=0;
		int spareMonth=0;
		//search the gregorian_century array for the correct entry and return the ordinal value
		for(int j=0; j<gregorian_century.length; j++)
			if(gregorian_century[j][0]==century)
			{
				ordinal=gregorian_century[j][1];
				break;
			}
		//search through gregorian_decade and find the first entry greater than decade
		for(int j=0;j<gregorian_decade.length;j++){
			if(gregorian_decade[j][0]>decade){
				if(j!=0){
					ordinal=ordinal+gregorian_decade[j-1][1];
					spareYears=decade-gregorian_decade[j-1][0];
					break;}
				else{//no need to add to ordinal
					spareYears=decade;
					break;
				}
			}
		}
		//if decade >=96 and <100 then the value will not have been found in gregorian_decade
		if((decade>=96)&&(decade<100)){//Adding this fixed error with years 1996-1999
			ordinal=ordinal+gregorian_decade[gregorian_decade.length-1][1];//35064
			spareYears=decade-96;
		}	
		
		//now index into the table for month data
		spareMonth = gregorian_month[month][spareYears+1];
		ordinal = ordinal + spareMonth + day;

		return ordinal;
	}

	protected String convertMisri(int monthDay, int month, int misriYear) {
		return "" + monthDay + getDaySuffix(monthDay) +  getMisriMonth(month) + misriYear;
	}

	public String convertGregorian(int monthDay, int month, int year){//pass month as zero based
		return "" + monthDay + getDaySuffix(monthDay) + getGregorianMonth(month) + year;
	}

	private String getGregorianMonth(final int month) {
		switch(month){
		case 0: return " January ";
		case 1: return " February ";
		case 2: return " March ";
		case 3: return " April ";
		case 4: return " May ";
		case 5: return " June ";
		case 6: return " July ";
		case 7: return " August ";
		case 8: return " September ";
		case 9: return " October ";
		case 10: return " November ";
		case 11: return " December ";
		default: return "";
		}
	}

	protected String getMisriMonth(final int month) {
		switch(month-1){
		case 0: return " Moharram-al-Haram ";
		case 1: return " Safar-al-Muzaffar ";
		case 2: return " Rabi-al-Awwal ";
		case 3: return " Rabi-al-Aakhar ";
		case 4: return " Jumada-al-Ulaa ";
		case 5: return " Jamada-al-Ukhra ";
		case 6: return " Rajab-al-Asab ";
		case 7: return " Shaban-al-Karim ";
		case 8: return " Ramadan-al-Moazzam ";
		case 9: return " Shawwal-al-Mukarram ";
		case 10: return " Zilqad-al-Haraam ";
		case 11: return " Zilhajj-al-Haraam ";
		default: return "";
		}
	}

	String getDaySuffix(final int day) {
		if (day >= 11 && day <= 13) {
			return "th";
		}
		switch (day % 10) {
		case 1: return "st";
		case 2: return "nd";
		case 3: return "rd";
		default: return "th";
		}
	}

	public void setEvent(int monthOfYear, int dayOfMonth) {
		todayMisriOrdinal = dayOfMonth + misri_month[monthOfYear-1];
		String eventString="";
		String allEventsString[];
		if(Misri.priorityEventMap.containsKey(todayMisriOrdinal)){
			allEventsString=Misri.priorityEventMap.get(todayMisriOrdinal);

			for(int x=0;x<allEventsString.length; x++){
				eventString += allEventsString[x];
				if(allEventsString.length>1&&x<allEventsString.length){
					eventString +=", ";
				}
			}
		}
		todayEvent = eventString;
	}

	public String getTodayEvent(){
		return todayEvent;
	}

	public int getTodayMisriDay() {
		return todayMisriDay;
	}
	

	public void setTodayMisriDay(int todayMisriDay) {
		this.todayMisriDay = todayMisriDay;
	}

	public String getTodayMisriMonth() {
		return todayMisriMonth;
	}

	public void setTodayMisriMonth(String todayMisriMonth) {
		this.todayMisriMonth = todayMisriMonth;
	}

	public int getTodayMisriYear() {
		return todayMisriYear;
	}

	public void setTodayMisriYear(int todayMisriYear) {
		this.todayMisriYear = todayMisriYear;
	}


	public int getTodayMisriMonthCode() {
		return todayMisriMonthCode;
	}


	public void setTodayMisriMonthCode(int todayMisriMonthCode) {
		this.todayMisriMonthCode = todayMisriMonthCode;
	}


	public int getConvertedGregorianDay() {
		return convertedGregorianDay;
	}


	public void setConvertedGregorianDay(int todayGregorianDay) {
		this.convertedGregorianDay = todayGregorianDay;
	}


	public int getConvertedGregorianYear() {
		return convertedGregorianYear;
	}


	public void setConvertedGregorianYear(int todayGregorianYear) {
		this.convertedGregorianYear = todayGregorianYear;
	}


	public int getConvertedGregorianMonth() {
		return convertedGregorianMonth;
	}


	public void setConvertedGregorianMonth(int todayGregorianMonth) {
		this.convertedGregorianMonth = todayGregorianMonth;
	}
}