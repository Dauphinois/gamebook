-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: gamebook
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `directionchance`
--

DROP TABLE IF EXISTS `directionchance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directionchance` (
  `idDepart` int NOT NULL,
  `idArrivee` int NOT NULL,
  `Chance` double NOT NULL,
  PRIMARY KEY (`idDepart`,`idArrivee`),
  KEY `FK_idArrivee_idx` (`idArrivee`),
  CONSTRAINT `FK_idArriveeChance` FOREIGN KEY (`idArrivee`) REFERENCES `scene` (`idScene`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_idDepartChance` FOREIGN KEY (`idDepart`) REFERENCES `scene` (`idScene`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directionchance`
--

LOCK TABLES `directionchance` WRITE;
/*!40000 ALTER TABLE `directionchance` DISABLE KEYS */;
INSERT INTO `directionchance` VALUES (2,3,1),(8,24,1),(10,24,1),(12,24,1),(18,24,1),(19,24,1),(21,24,1),(26,27,0.8),(26,28,0.2),(28,24,1),(32,35,1),(34,35,1),(37,38,1),(41,43,1),(42,43,1),(48,49,1),(53,54,1),(66,54,1),(69,79,1),(72,79,1),(75,79,1),(77,79,1),(84,91,1),(88,91,1),(90,91,1),(101,7,0.35),(101,8,0.65),(102,12,0.7),(102,13,0.3),(103,17,0.8),(103,18,0.2),(104,32,0.6),(104,33,0.4),(105,72,0.5),(105,73,0.5),(106,75,0.5),(106,76,0.5),(107,89,0.7),(107,90,0.3),(108,96,0.5),(108,97,0.5),(109,96,0.5),(109,97,0.5);
/*!40000 ALTER TABLE `directionchance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directionchoice`
--

DROP TABLE IF EXISTS `directionchoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directionchoice` (
  `idDepart` int NOT NULL,
  `idArrivee` int NOT NULL,
  `Texte` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idDepart`,`idArrivee`,`Texte`),
  KEY `FK_idArrivee_idx` (`idArrivee`),
  CONSTRAINT `FK_idArriveeChoice` FOREIGN KEY (`idArrivee`) REFERENCES `scene` (`idScene`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_idDepartChoice` FOREIGN KEY (`idDepart`) REFERENCES `scene` (`idScene`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directionchoice`
--

LOCK TABLES `directionchoice` WRITE;
/*!40000 ALTER TABLE `directionchoice` DISABLE KEYS */;
INSERT INTO `directionchoice` VALUES (1,2,'Supporter Enmieux et devenir le général qui envahira les territoires rivaux'),(3,4,'Brutus César : sanguinaire et tortionnaire, il utillise toutes les fourberies pour arriver à ses fins'),(4,5,'Vous suivez le mouvement'),(4,6,'Vous désertez'),(5,9,'L\'en dissuader'),(5,10,'Hors de question'),(3,11,'Alex Le Grand : Calculateur et manipulateur, il ne part pas en guerre sans être certain de gagner'),(3,15,'Napoléo II : arrogant et impétueux, il est craint de tous et vit comme il l\'entend'),(15,16,'Le poignarder dans son sommeil'),(15,19,'Prendre en otage sa femme et ses enfants'),(15,20,'Le tuer en l\'empoisonnant'),(15,21,'Le tuer dans le brouhaha d\'une bataille'),(15,22,'Monter son armée contre lui'),(15,23,'Ne rien faire'),(15,25,'Gagner ses faveurs en l\'imitant'),(3,26,'Duke Khan: ardente et impulsive, elle n\'hésite pas à essuyer de grande pertes pour remporter les batailles'),(24,29,'Ne pas déclarer de guerre'),(24,30,'Déclarer la guerre à Queen'),(30,31,'Mener une attaque maritime en navire de guerre'),(30,34,'Faire un blocus autour de l\'île'),(35,36,'Faire croire que vous l\'avez aussi'),(35,37,'Envoyer une unité spéciale pour faire assassiner le dictateur'),(24,38,'Déclarer la guerre à Weimahr'),(38,39,'L\'assiéger'),(38,40,'Charger de toutes vos forces'),(38,41,'Empoisonner leur réserve d\'eau'),(38,42,'Transmettre la rage en envoyant des rats'),(43,44,'Kevin'),(43,45,'Gaetan'),(24,46,'Déclarer la guerre aux deux'),(1,48,'Supporter Queen et devenir espion et renverser les dirigeants ennemis dans l\'ombre'),(49,50,'L\'école d\'espion de Rocks: L\'école la plus prestigieuse du Royaume en terme d\'espionnage. Tous les diplômés deviennent des atouts pour la nation.'),(50,51,'En présentiel'),(50,52,'Distanciel'),(51,53,'En chemise'),(54,55,'Luigi'),(55,56,'Iran'),(56,57,'La Haute Marne'),(57,58,'Audrey Tautou'),(58,59,'Le dong'),(59,60,'Vierge'),(54,61,'Bowser'),(54,61,'Wario'),(54,61,'Yoshi'),(55,61,'Irak'),(55,61,'Kazakhstan'),(55,61,'Liban'),(56,61,'La Corrèze'),(56,61,'La Mayenne'),(56,61,'Le Gers'),(57,61,'Cécile de France'),(57,61,'Marion Cotillard'),(57,61,'Mélanie Laurent'),(58,61,'Le dang'),(58,61,'Le deng'),(58,61,'Le ding'),(59,61,'Balance'),(59,61,'Bélier'),(59,61,'Poisson'),(60,61,'Hubert de Givenchy'),(60,61,'Jean Paul Gaultier'),(60,61,'Pierre Gautier'),(60,62,'Christian Lacroix'),(51,63,'En costume 3 pièces'),(51,64,'En T-shirt'),(52,66,'En chemise'),(52,66,'En costume 3 pièces'),(52,66,'En T-shirt'),(52,66,'En tenue de clown'),(49,67,'Shark Université: Une université faite pour les génies. Mais seulement les génies fortunés. Les frais de scolarité sont parmi les plus onéreux du continent.'),(67,68,'Se dégoter un sugar daddy'),(68,69,'Holmes'),(68,70,'Moriarty'),(67,71,'Emprunter une énorme somme d\'argent d\'une personne douteuse'),(67,74,'Ouvrir un OnlyFans'),(49,77,'Stanford : Une école prestigieuse pour son campus luxuriant et ses taux d\'admissions négatifs'),(49,78,'L\'école de la vie: Une école des plus banales qui vous offre des enseignements sur les petits plaisirs du quotidien. Tout simplement.'),(79,80,'Sa famille'),(79,81,'Son stratège'),(79,82,'Son coach'),(82,83,'Du cyanure'),(82,84,'De l\'antigel'),(82,84,'Du venin de scorpion'),(82,85,'2 boîtes de doliprane'),(79,86,'Son prêtre'),(79,87,'Son amant'),(87,88,'Piéger le lieu du rendez-vous avec du C4'),(91,92,'Faire du parkour sur les toits en tâchant d\'être discret'),(91,93,'Rentrer par la grande porte (plus c\'est gros, plus ça passe)'),(93,94,'Vous vous cachez à l\'étage et utilisez un fusil de sniper'),(93,95,'Contacter la milice révolutionnaire et ouvrir les portes du banquet'),(92,98,'Empoisonner le vin dans la cuisine'),(93,98,'Empoisonner le vin dans la cuisine'),(1,99,'Supporter Weimahr et suivre le dictateur. Ses decisions sont toujours les plus justes'),(11,100,'Le confronter sur sa décision'),(5,101,'Suivre ses ordres'),(11,102,'Le suivre'),(15,103,'Le déclarer en duel'),(30,104,'Mener une attaque terrestre'),(67,105,'Vendre tous les organes vendables de votre corps'),(67,106,'Epouser un(e) vieux/vieille riche dans l\'espoir qu\'il/elle meurt très prochainement'),(87,107,'Lui tirer dessus à vue'),(92,108,'Pourquoi être discret ? On explore tout'),(93,109,'Pourquoi être discret ? On explose tout');
/*!40000 ALTER TABLE `directionchoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endings`
--

DROP TABLE IF EXISTS `endings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endings` (
  `idScene` int NOT NULL,
  `Status` varchar(31) NOT NULL,
  `Age` int DEFAULT NULL,
  `Completeness` double NOT NULL,
  PRIMARY KEY (`idScene`),
  CONSTRAINT `FK_idSceneEndings` FOREIGN KEY (`idScene`) REFERENCES `scene` (`idScene`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endings`
--

LOCK TABLES `endings` WRITE;
/*!40000 ALTER TABLE `endings` DISABLE KEYS */;
INSERT INTO `endings` VALUES (6,'soldat',18,0),(7,'lieutenant',22,0.06),(9,'lieutenant',22,0.06),(13,'bras droit du général',25,0.06),(16,'caporal',26,0.08),(17,'caporal',21,0.08),(20,'sergent',32,0.1),(22,'colonel',45,0.15),(23,'commandant',88,0.13),(25,'capitaine',40,0.15),(27,'soldat',18,0),(29,'général',88,0.33),(31,'général',50,0.4),(33,'général',51,0.4),(36,'général',60,0.6),(39,'général',65,0.8),(40,'général',65,0.8),(44,'général',55,0.5),(45,'général',60,0.6),(46,'général',52,0.33),(47,'général',70,1),(61,'sans emploi',17,0.25),(62,'étudiant',17,0.6),(63,'rigolo',17,0.14),(64,'idiot',17,0.14),(70,'malchanceux',17,0.25),(71,'naïf',17,0.2),(73,'avide',17,0.25),(74,'simplet',17,0.2),(76,'frêle',32,0.4),(78,'inconnu',80,1),(80,'consultant de la CIAA',32,0.6),(81,'consultant de la CIAA',32,0.6),(83,'consultant de la CIAA',32,0.7),(85,'consultant de la CIAA',32,0.7),(86,'être immonde',24,0.7),(89,'consultant de la CIAA',32,0.7),(94,'général',52,1),(95,'général',52,1),(96,'idiot',46,0.85),(97,'consultant de la CIAA',46,0.85),(98,'consultant de la CIAA',46,0.85),(99,'inexistant',15,0),(100,'soldat',17,0.1);
/*!40000 ALTER TABLE `endings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scene`
--

DROP TABLE IF EXISTS `scene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene` (
  `idScene` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idScene`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scene`
--

LOCK TABLES `scene` WRITE;
/*!40000 ALTER TABLE `scene` DISABLE KEYS */;
INSERT INTO `scene` VALUES (1,'Le continent est divisé en 3 régions rivales. Le royaume de Queen, la République démocratique, populaire et bienveillante de Weimahr et l\'Empire Enmieux. Queen est un royaume intellectuel et tres poussé dans l\'espionnage. La République est une dictature extrêmement talentueuse dans la technologie et les innovations. L\'empire est une nation guerrière qui vit pour la conquête. Où souhaitez-vous débuter votre aventure ?'),(2,'Vous êtes un civil. Comme vous avez été endoctriné, vos idoles sont les héros de guerre et vous rêvez d\'en devenir un à votre tour. Vous vous enrôlez dans l\'armée avec d\'énormes ambitions et notamment de devenir le général en charge d\'envahir tout le continent.'),(3,'Choisissez votre commandant.'),(4,'Vous assistez à votre premier massacre et pillage. Comment réagissez-vous ?'),(5,'Bonne décision, un autre soldat s\'est indigné et sa tête a volé. Quelques mois plus tard, Vous remportez une éinieme victoire avec Brutus et cette fois-ci vous mettez la main sur 10000 prisonniers de guerre. Brutus décide de les tuer pour l’exemple'),(6,'Vous êtes mort, personne ne déserte'),(7,'Brutus devient l\'homme le plus detesté hors de l\'empire, les deux autres pays s\'allieront avec un but commun d\'arracher la tête de Brutus, et il réussiront. Vous mourrez aussi dans cette offensive.'),(8,'Brutus devient l\'homme le plus detesté hors de l\'empire, les deux autres pays s\'allieront avec un but commun d\'arracher la tête de Brutus, et il réussiront. Vous réussissez à fuir en limitant les dégats.'),(9,'Vous n’êtes pas digne d’être son bras droit. Il vous fait exécuter avec les prisonniers'),(10,'Vous poignardez César dans le dos. Son armée ne dit rien, tout le monde était du même avis que vous.'),(11,'Alex décide de partir en guerre mais vous avez un mauvais préssentiment. Vous êtes son conseiller, quelle est votre décision.'),(12,'Vous êtes victorieux mais votre préssentiment s’est révélé avéré. Une maladie propagé par l\'ennemi décime la presque totalité des troupes . Alex meurt de la même maladie mais vous confie ses troupes restantes .'),(13,'Vous êtes victorieux mais votre préssentiment s’est révélé avéré. Une maladie propagé par l\'ennemi décime la presque totalité des troupes . Vous mourez aussi de cette maladie.'),(14,'L\'autorité du chef de guerre est absolu. Vous êtes expulser de son armée. Choisissez entre Khan, Brutus et Napoléo'),(15,'Napoléo préfère batifoler aux quartiers des plaisirs et s’amuser dans les jeux d’argent plutôt que d\'agrandir son palmarès de guerre. Il utilise tout l’argent alloué à l’entretien de ses hommes dans ses propres plaisirs personnels. Que faites vous ?'),(16,'Vous êtes malin mais un voisin vous a vu faire.'),(17,'La différence de niveau entre Napoleo et vous est imcommensurable. Vous mourez lamentablent'),(18,'Par un enchaînement d\'évènement miraculeux, vous arrivez à le blesser, vous vous enfuyez en le laissant se vider de son sang. Vous êtes un lâche mais un lâche victorieux.'),(19,'Vous arrivez même a l\'obliger à faire de vous son successeur avant de le tuer.'),(20,'Vous réussissez à le tuer. Une enquête est ouverte et l\'homme qui vous a vendu le poison vous vend immediatement.'),(21,'Votre tir de carabine se loge dans l\'arrière de son crâne et dans le feu de l\'action, votre crime se camoufle parmi tant d\'autres, son armée est désormais la votre.'),(22,'On a oublié de vous préciser que son armée lui est fidèle comme un chien a son maître. Vous êtes empalé sur le champ'),(23,'La situation ne changera pas et vous finirez votre vie sous les ordres de Napoleo qui finira par réaliser vos rêves à votre place. Tous vos efforts n\'auront servi à rien'),(24,'Vous êtes à présent général. Quel est votre première action ?'),(25,'Vous attrapez la syphillis en menant une vie de débauche, vous mourez la queue entre les jambes d\'une fille de joie'),(26,'Vous êtes envoyé comme unité kamikaze'),(27,'On vous avait prévenu !'),(28,'Par miracle, vous avez survécu. Khan vous prend sous son aile. Au fil des années, vous faites preuve de prouesse et devenez son bras droit après de campagnes triomphantes. Khan prend sa retraite due à sa vieillesse. Vous êtes le candidat tout choisi pour prendre ses fonctions. Vous êtes à présent général. Quel est votre première action ?'),(29,'Les trois pays sont en position de status quo. La guerre continuera et le sang coulera toujours. Vous décidez juste de ne pas intervenir pour ne pas vous salir les mains mais ça ne vous rend pas moins coupable. Vous finirez une vie terne et insipide.'),(30,'La conquête de Queen se repose principalement sur le contrôle d\'Eldia, une île de Queen qui ouvrira une voie de ravitaillement par la mer. Comment prendre Eldia ?'),(31,'Dommage pour vous, Eldia est surpuissante en mer. Vous n\'êtes pas de taille contre leur flotte.'),(32,'Vous êtes victorieux. Vous vous emparez d\'Eldia. Eldia conquis, la suite de l\'invasion se déroule sans accroc. Vous avez conquis le Royaume de Queen !'),(33,'Vous perdez la bataille.  Vous rentrez chez vous bredouille. Vous n\'êtes pas aussi compétent que vous pensiez l\'être'),(34,'Vous réussissez à affamer toute l\'île. Vous vous emparez d\'Eldia. Eldia conquis, la suite de l\'invasion se déroule sans accroc. Vous avez conquis le Royaume de Queen !'),(35,'Weimahr, étant le seul territoire disposant de la bombe nucléaire et se sentant en danger, vous menace d\'envoyer ses ogives. Que faite vous ?'),(36,'Le dictateur ne tombe pas dans votre jeu. Votre empereur meurt sous les frappes ennemis ainsi que 10 million des vôtres. Vous capitulez, la défaite est totale et bien amère.'),(37,'La mission se passe sans problème: Plus de risque nucléaire, vous pouvez à présent lancer votre attaque.'),(38,'La conquête de Weimahr se repose principalement sur le contrôle de Rocks, une forteresse perché en hauteur. Comment prendre Rocks ?'),(39,'Rocks est autosuffisante, le siège ne mène à rien.'),(40,'L\'ennemi est plus robuste que prévu, la campagne se solde par un échec cuisant.'),(41,'Le stratégie, bien que répugnante, est efficace. Rocks tombe en une semaine. Rocks conquis, la suite de l\'invasion se déroule sans accroc. Vous vous emparez de Weimahr !'),(42,'Votre idée est aussi méprisable que ravageuse, la cité tombe le jour même. Rocks conquis, la suite de l\'invasion se déroule sans accroc. Vous vous emparez de Weimahr !'),(43,'Cependant, pendant votre invasion, Queen a introduit des espions au sein de votre armée. Vous devez retrouver celui qui se cache dans votre cercle proche. Est-ce Kevin votre stratège ou Gaetan le formateur des recrues ?'),(44,'Vous avez raison, il s\'est servi de vous pour conquérir Weimahr sans concéder de perte pour Queen et et comptait vous menez à votre perte durant votre prochaine campagne. Une bonne chose de faite.'),(45,'Pas de chance. Gaetan était innocent. Kevin, le traître, vous induira en erreur en vous conseillant de prendre les pires décisions possibles'),(46,'Vous divisez vos unités en deux pour attaquer 2 fronts. Ce qui est totalement stupide. Vous vous faites engloutir.'),(47,'Félicitations, vous avez unifier le continent, vous êtes un héros !!!'),(48,'Vous êtes un orphelin de guerre. Votre père s\'est fait bomber par un nouveau test de la République. Votre mère s\'est ensuite faite enlever par ces barbares de l\'Empire. Vous jurez de venger vos parents mais votre seul point fort est votre cerveau. Vous aspirez donc à devenir l\'espion qui manipulera les ennemis.\nVous avez de la chance, votre pays est spécialisé dans cet art. Il vous faut d\'abord vous instruire.'),(49,'Dans quelle école allez-vous ?'),(50,'Vous passez l\'entretien de l\'école de Rocks. Vous avez le choix de le passer en présentiel ou en distanciel ?'),(51,'Comment vous habillez-vous ?'),(52,'Qu\'allez-vous vêtir ?'),(53,'L\'entretien se passe bien. Pour finir, quelques questions de culture générale.'),(54,'Comment s\'appelle le frère de Mario ?'),(55,'Question suivante ! Quelle est l\'origine du chanteur Shervin Hajipour ?'),(56,'Question suivante ! Dans quel département se situe la ville de Saint Dizier ?'),(57,'Question suivante ! Qui incarne Gabrielle Chanel dans le film \'Coco avant Chanel\' de 2009 ?'),(58,'Question suivante ! Quel est la monnaie du Vietnam ?'),(59,'Question suivante ! Lequel de ces signe du zodiac est un signe de Terre ?'),(60,'Question suivante ! Quel couturier a relooké les TGV en 2005 ?'),(61,'Faux ! Thank you next'),(62,'Vous avez réussi, vous intégrez l\'école de d\'espion. Bravo, vous avez réussi, vous êtes admis !'),(63,'Wow à qui essayez-vous de prouver que vous avez les compétences alors que vous n\'avez rien ? C\'est un total échec, le recruteur voit clair dans votre jeu'),(64,'Vous êtes recalé. Ce n\'est pas un accoutrement pour vous présenter à un entretien'),(66,'Aucun problème, l\'usage de la caméra n\'est pas requis. L\'entretien se passe bien, maintenant une session de culture générale. Vous pouvez utiliser internet et chatgpt, personne ne saura.'),(67,'Pour avoir une chance d\'être admis a Shark université, encore faut-il avoir l\'argent. Etant orphelin, il vous faudra trouver un moyen de récolter de l\'argent.'),(68,'Jamais un sugar daddy ne payera jamais vos études! Il faudrait être fou ! Et donc vous en trouvez 2.   M. Holmes et Moriarty proposent de financer vos études. A qui choisissez-vous de faire confiance ?'),(69,'C\'est un homme qui vient de perdre son enfant et sa femme dans un accident tragique. Il fait de vous son enfant, vous n\'avez à présent plus besoin de vous préoccuper de l\'argent et vous présentez Shark Université et vous êtes reçu !'),(70,'Moriarty se révèle être un fou sadique. Vous mourrez seul dans une cave après qu\'il ait abusé de vous.'),(71,'L\'argent emprunté venait de la mafia… En apprenant que vous avez utilisé leur argent pour payer des frais scolaires, la mafia se rend compte qu\'ils ne reverront plus leur argent. Un beau jour, vous vous retrouvez dans un conteneur prêt à être disséquer et tous vos organes vendus.'),(72,'Vous vous faite la coquette somme de 35 millions de roupie royaux. Vous entrez sans difficulté à Shark Université.'),(73,'Vous ne vous sentez pas bien. Vous ne savez pas que l\'on vous a prélevé une quantité trop importante de votre foie. Vous développez un diabète de type 1 et 2, ce qui vous sera fatal.'),(74,'Vous êtes décidément pas très malin, vous voulez devenir espion et vous vous afficher devant le monde. Vous ne passerez jamais inaperçu. Au revoir, brillante carrière d\'espion'),(75,'La personne meurt très rapidement. Youpi !!! Vous vous inscrivez de ce pas à Shark Université, et êtes reçu après avoir graisser la patte du recruteur.'),(76,'Wow, votre conjoint a une longévité remarquable, vous mourrez avant lui.'),(77,'Vous êtes refusé. Au revoir……. Attendez voir vite fait ! Vous avez dit que vous étiez orphelin ? Alors pourquoi vous ne l\'avez pas dit plutôt ? Bienvenue à Stanford !!!'),(78,'Vous vivez une vie tranquille et ne vous démarquez d\'aucune façon. Personne ne se souviendra de vous mais au moins vous avez été heureux.'),(79,'Le dictateur est un homme méticuleux. Il ne se montre qu\'a sa famille, son stratège militaire, son coach de krav-maga, son prêtre et son amant. De qui allez-vous vous servir ?'),(80,'Vous kidnappez sa femme et ses deux enfants. Vous essayez de le contacter pour organiser un rdv sous prétexte de récupérer la rançon et le tuer dès qu\'il se présente. Mais le dictateur n\'a que faire de sa famille. Pire encore, vous lui rendez service et lui facilitez son coming-out.'),(81,'Vous essayez de remplacer son stratège. Mais le dictateur a toujours admiré l\'Allemagne de la Grande Guerre et vous n\'êtes malheureusement pas blond aux yeux bleus. Vous êtes malheureusement recalé'),(82,'Vous essayez de vous incruster dans le même cours de krav-maga. Vous pouvez ainsi empoisonner son shaker protéiné. Quel poison utilisé vous ?'),(83,'Vous avez échoué, le dictateur mange énormément de pomme et les pepins avec. Il est immunisé au cyanure.'),(84,'Pouf, plus de dictateur. Mission réussi ! Maintenant, au tour de l\'empereur.'),(85,'Le dictateur est tellement stressé au quotidien qu\'il ingère du doliprane en permanence et en est immunisé.'),(86,'Vous êtes fou ! Même chez les espions, on ne touche pas aux prêtres. Vous êtes exécuté sur le champ'),(87,'Vous avez touché la corde sensible du dictateur. Un rdv est organisé et vous avez maintenant une audience avec lui. Que faire ?'),(88,'BOOM ! On en parle plus. Mission réussi ! Maintenant, au tour de l\'empereur.'),(89,'Il portait un gilet par balle, qui a absorbé tous vos tirs. Ses gardes du corps vous met hors d\'état de nuire'),(90,'Il portait un gilet par balle mais vous lui mettez un headshot mémorable. Il tombe sur le coup, décédé. Mission réussi ! Maintenant, au tour de l\'empereur.'),(91,'L\'empereur organise un immense banquet pour fêter son anniversaire. Trouver un moyen de vous inviter.'),(92,'Vous êtes maintenant au banquet.'),(93,'Ça passe ! Vous êtes maintenant au banquet. \n,Vous avez l\'empereur dans votre champ de vision mais il toujours entouré. Il vous faut être discret. Que faire ?'),(94,'Simple, efficace, comme on les aime. Parfois, il ne faut pas chercher compliqué. Mission réussi !'),(95,'Wow ! Quelle idée brillante ! Vous faite d\'une pierre 2 coups en tuant l\'empereur et en ne salissant pas les mains. Mission réussi !'),(96,'Dans ce feu d\'artifice de dégât , vous assassinez l\'empereur et vous arrivez à fuir dans le chaos de la foule. Mission réussi !'),(97,'En jetant énormément de grenades, vous vous faites exploser aussi par mégarde.'),(98,'Une cuisinière vous surprend de loin, avertit un garde et vous finissez exécuté.'),(99,'C\'est une dictature… Vous ne devez vraiment pas trop vous aimer pour choisir consciemment d\'appartenir à une dictature. Choisissez un autre camp s\'il vous plait. Pour l\'amour du Ciel !'),(100,'Mauvaise idée, il faut fait immédiatement exécuter'),(101,'Vous suivez ses ordres'),(102,'Vous le suivez'),(103,'Vous le déclarez en duel'),(104,'Vous menez une attaque terrestre'),(105,'Vous vendez tous vos organes vendables à un homme douteux dans une petite ruelle'),(106,'Vous demandez en mariage la première personne que vous croisez dans la rue'),(107,'Vous lui tirez dessus immédiatement'),(108,'Vous faites tout péter'),(109,'Vous faites tout péter');
/*!40000 ALTER TABLE `scene` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-23  1:19:01
