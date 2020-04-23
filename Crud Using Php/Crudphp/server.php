<?php

    session_start();

    $name ="";
    $address ="";
    $id = 0;
    $edit_state =false;


    $db = mysqli_connect('localhost', 'root', '', 'crud');

    if(isset($_POST['save'])){
        $name = $_POST['name'];
        $address = $_POST['address'];

        $query = "INSERT INTO info (name,address) VALUES('$name', '$address')";
        mysqli_query($db, $query);
        $_SESSION['msg'] = "Successfully Inserted ";
        header ('location: index.php');
    }


//update
if(isset($_POST['update'])){
    $id = $_POST['id'];
    $name = $_POST['name'];
    $address =$_POST['address'];
    

    mysqli_query($db, "UPDATE info SET name ='$name' , address='$address' WHERE id = $id " );
    $_SESSION['msg'] ="Address updated";
    header ('location: index.php');
}

//delete

if(isset($_GET['del'])){
    $id = $_GET['del'];
    mysqli_query($db , "DELETE FROM info WHERE id= $id");
    $_SESSION['msg'] ="Address Deleted";
    header ('location: index.php');
}


//retrieve recodes

$results = mysqli_query($db, "SELECT * FROM info");


?>