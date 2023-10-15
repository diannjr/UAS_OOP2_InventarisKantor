<?php 
    include "config/koneksi.php";
?>

<!doctype html>
    <html lang="en">
        <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <title>LAPORAN INVENTARIS BARANG KELUAR</title>
    </head>

    <body onload="window.print()">
        <div class="container">
        <div class="row">
            <div class="col-md-12"><h1 class="text-center text-primary">LAPORAN INVENTARIS BARANG KELUAR</h1>
                    <?php
                        $tanggal = date('Y-m-d');
                        echo $tanggal;
                    ?>
                </div>
            </div>

            <br>
            <br>
            <br>
            <div class="row">
                <div class="col-md-12">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>Kode Keluar</th>
                                <th>Kode Inventaris</th>
                                <th>Kode Barang</th>
                                <th>Nama Barang</th>
                                <th>Kategori</th>
                                <th>Merk</th>
                                <th>Jumlah</th>
                                <th>Kode Lokasi</th>
                                <th>Nama Lokasi</th>
                                <th>Keterangan</th>
                                <th>Tanggal Keluar</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                                <?php 
                                    $sql = "SELECT * FROM tbl_keluar";
                                    $query = mysqli_query($con, $sql);
                                    while($r= mysqli_fetch_array($query)){
                                ?>
                        <tr>
                            <td><?php echo $r['kd_keluar'] ?></td>
                            <td><?php echo $r['kd_inventaris'] ?></td>
                            <td><?php echo $r['kd_barang'] ?></td>
                            <td><?php echo $r['nama_barang'] ?></td>
                            <td><?php echo $r['kategori'] ?></td>
                            <td><?php echo $r['merk'] ?></td>
                            <td><?php echo $r['jumlah'] ?></td>
                            <td><?php echo $r['kd_lokasi'] ?></td>
                            <td><?php echo $r['nama_lokasi'] ?></td>
                            <td><?php echo $r['keterangan'] ?></td>
                            <td><?php echo $r['tanggal_keluar'] ?></td>
                        </tr>
                        
                        <?php } ?>
                        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    
            <script src="js/bootstrap.min.js"></script>
        </body>

    </html>