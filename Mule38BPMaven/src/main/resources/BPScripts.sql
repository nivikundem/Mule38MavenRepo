
--DROP TABLE IF EXISTS `bp`.`bptransactions`;
CREATE TABLE  `bp`.`bptransactions` (
  `bptransactionsID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `batchName` varchar(45) NOT NULL DEFAULT '',
  `Status` varchar(45) NOT NULL DEFAULT '',
  `Servername` varchar(45) NOT NULL DEFAULT '',
  `mmid` varchar(45) NOT NULL DEFAULT '',
  `Message` varchar(16000) NOT NULL DEFAULT '',
  `messageRef` varchar(45) NOT NULL DEFAULT '',
  `transactionType` varchar(45) NOT NULL DEFAULT '',
  `transactionRef` varchar(45) NOT NULL DEFAULT '',
  `DateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DateUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`bptransactionsID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `bp`.`logfailure`;
CREATE TABLE  `bp`.`logfailure` (
  `LogFailureId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Process` varchar(45) NOT NULL DEFAULT '',
  `Message` varchar(45) NOT NULL DEFAULT '',
  `AdditionalText` varchar(45) NOT NULL DEFAULT '',
  `servername` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`LogFailureId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `bp`.`bpbatch`;
CREATE TABLE  `bp`.`bpbatch` (
  `bpbatchID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `batchName` varchar(45) NOT NULL DEFAULT '',
  `Status` varchar(45) NOT NULL DEFAULT '',
  `Servername` varchar(45) NOT NULL DEFAULT '',
  `mmid` varchar(45) NOT NULL DEFAULT '',
  `DateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `noOfTransactions` int(10) ,
  PRIMARY KEY (`bpbatchID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;