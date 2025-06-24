<?php
class aluno { //classe pai ou mãe (superclasse)
	protected $ra;
	public function setRa($r) {
	   $this->ra = $r;
	   echo "Ra: $this->ra";
	}
}
class graduacao extends aluno{ //graduacao filho de aluno
	protected $tcc;

	public function setTCC($t){
		$this->tcc = $t;
		echo "TCC: $this->tcc";
	}
}
$a = new aluno();
$a->setRA("12345");
$a = new graduacao();//$a é um objeto da classe graduacao
$a->setRa("67890");
$a->setTCC("Programação Web");
?>