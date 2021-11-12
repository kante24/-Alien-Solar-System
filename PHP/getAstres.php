<?php
$url ="mysql:host=localhost:3306;dbname=AlienSolarSystem";
$dbuser = "root";
$dbpw = "";
try
{
	$dbcon = new PDO($url,$dbuser,$dbpw);
	$dbcon->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
	
	$cmd = $dbcon->prepare("SELECT * FROM AstreCeleste");
	$cmd -> execute();
	$out = "";
	$line;
	while ($rec = $cmd->fetchObject()) {
		foreach ($rec as $key => $value) {
			$out .= $value . "#";
		}
		$out .= "/";
		echo $out;
	}
	
}
catch(Exception $ex)
{
	$out = $ex->getMessage();
	
}
echo $out;
?>