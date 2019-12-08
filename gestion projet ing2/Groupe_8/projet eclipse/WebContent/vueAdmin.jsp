<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
        
        <!-- Title -->
        <title>Gestion-Projet</title>
        
       <jsp:include page="header.jsp" />

        
    </head>
    <body class="page-header-fixed">
        <div class="overlay"></div>
        <div class="menu-wrap">
            <nav class="profile-menu">
                <div class="profile"><img src="${pageContext.request.contextPath}/assets/images/avatar1.png" width="52px" alt="Administrateur"/><span><c:out value = "${user.getNom() }" /></span></div>
                <div class="profile-menu-list">
                    <i class="fa fa-user"></i> <p>Nom : <c:out value = "${user.getNom() }" /></p>
                    <i class="fa fa-bell"></i> <p>Prenom : <c:out value = "${user.getPrenom() }" /></p>
                    <i class="fa fa-user"></i> <span>Fonction : <c:out value = "${user.getFonction() }" /></p>
                    <i class="fa fa-user"> </i><p> Login : <c:out value = "${user.getLogin() }" /></p>
                    
                </div>
            </nav>
            <button class="close-button" id="close-button">Close Menu</button>
        </div>
        <form class="search-form" action="#" method="GET">
            <div class="input-group">
                <input type="text" name="search" class="form-control search-input" placeholder="Search...">
                <span class="input-group-btn">
                    <button class="btn btn-default close-search waves-effect waves-button waves-classic" type="button"><i class="fa fa-times"></i></button>
                </span>
            </div><!-- Input Group -->
        </form><!-- Search Form -->
        <main class="page-content content-wrap">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="sidebar-pusher">
                        <a href="javascript:void(0);" class="waves-effect waves-button waves-classic push-sidebar">
                            <i class="fa fa-bars"></i>
                        </a>
                    </div>
                    <div class="logo-box">
                        <a href="index.html" class="logo-text"><span>G-PROJET</span></a>
                    </div><!-- Logo Box -->
                    <div class="search-button">
                        <a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                    </div>
                    <div class="topmenu-outer">
                        <div class="top-menu">
                            <ul class="nav navbar-nav navbar-left">
                                <li>		
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic sidebar-toggle"><i class="fa fa-bars"></i></a>
                                </li>
                                <li>
                                    <a href="#cd-nav" class="waves-effect waves-button waves-classic cd-nav-trigger"><i class="fa fa-diamond"></i></a>
                                </li>
                                <li>		
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic toggle-fullscreen"><i class="fa fa-expand"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
                                        <i class="fa fa-cogs"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-md dropdown-list theme-settings" role="menu">
                                        <li class="li-group">
                                            <ul class="list-unstyled">
                                                <li class="no-link" role="presentation">
                                                    Fixed Header 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right fixed-header-check" checked>
                                                    </div>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="li-group">
                                            <ul class="list-unstyled">
                                                <li class="no-link" role="presentation">
                                                    Fixed Sidebar 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right fixed-sidebar-check">
                                                    </div>
                                                </li>
                                                <li class="no-link" role="presentation">
                                                    Horizontal bar 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right horizontal-bar-check">
                                                    </div>
                                                </li>
                                                <li class="no-link" role="presentation">
                                                    Toggle Sidebar 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right toggle-sidebar-check">
                                                    </div>
                                                </li>
                                                <li class="no-link" role="presentation">
                                                    Compact Menu 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right compact-menu-check">
                                                    </div>
                                                </li>
                                                <li class="no-link" role="presentation">
                                                    Hover Menu 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right hover-menu-check">
                                                    </div>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="li-group">
                                            <ul class="list-unstyled">
                                                <li class="no-link" role="presentation">
                                                    Boxed Layout 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right boxed-layout-check">
                                                    </div>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="li-group">
                                            <ul class="list-unstyled">
                                                <li class="no-link" role="presentation">
                                                    Choose Theme Color
                                                    <div class="color-switcher">
                                                        <a class="colorbox color-blue" href="indexca00.html?theme=blue" title="Blue Theme" data-css="blue"></a>
                                                        <a class="colorbox color-green" href="indexaf91.html?theme=green" title="Green Theme" data-css="green"></a>
                                                        <a class="colorbox color-red" href="index0e99.html?theme=red" title="Red Theme" data-css="red"></a>
                                                        <a class="colorbox color-white" href="index13d4.html?theme=white" title="White Theme" data-css="white"></a>
                                                        <a class="colorbox color-purple" href="index938c.html?theme=purple" title="purple Theme" data-css="purple"></a>
                                                        <a class="colorbox color-dark" href="index4965.html?theme=dark" title="Dark Theme" data-css="dark"></a>
                                                    </div>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="no-link"><button class="btn btn-default reset-options">Reset Options</button></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li>	
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown"><i class="fa fa-envelope"></i><span class="badge badge-success pull-right">4</span></a>
                                    <ul class="dropdown-menu title-caret dropdown-lg" role="menu">
                                        <li><p class="drop-title">You have 1 new  message !</p></li>
                                        <li class="dropdown-menu-list slimscroll messages">
                                            <ul class="list-unstyled">
                                                <li>
                                                    <a href="#">
                                                        <div class="msg-img"><div class="online on"></div><img class="img-circle" src="assets/images/avatar2.png" alt=""></div>
                                                        <p class="msg-name">Sandra Smith</p>
                                                        <p class="msg-text">Hey ! I'm working on your project</p>
                                                        <p class="msg-time">3 minutes ago</p>
                                                    </a>
                                                </li>
                                               
                                 
                                              
                                              
                                            </ul>
                                        </li>
                                        <li class="drop-all"><a href="#" class="text-center">All Messages</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown"><i class="fa fa-bell"></i><span class="badge badge-success pull-right">3</span></a>
                                    <ul class="dropdown-menu title-caret dropdown-lg" role="menu">
                                        <li><p class="drop-title">You have 3 pending tasks !</p></li>
                                        <li class="dropdown-menu-list slimscroll tasks">
                                            <ul class="list-unstyled">
                                                <li>
                                                    <a href="#">
                                                        <div class="task-icon badge badge-success"><i class="icon-user"></i></div>
                                                        <span class="badge badge-roundless badge-default pull-right">1min ago</span>
                                                        <p class="task-details">New user registered.</p>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <div class="task-icon badge badge-danger"><i class="icon-energy"></i></div>
                                                        <span class="badge badge-roundless badge-default pull-right">24min ago</span>
                                                        <p class="task-details">Database error.</p>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <div class="task-icon badge badge-info"><i class="icon-heart"></i></div>
                                                        <span class="badge badge-roundless badge-default pull-right">1h ago</span>
                                                        <p class="task-details">Reached 24k likes</p>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="drop-all"><a href="#" class="text-center">All Tasks</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
                                        <span class="user-name"><c:out value = "${user.getNom() }" /><i class="fa fa-angle-down"></i></span>
                                        <img class="img-circle avatar" src="assets/images/avatar1.png" width="40" height="40" alt="">
                                    </a>
                                    <ul class="dropdown-menu dropdown-list" role="menu">
                                        <li role="presentation"><a href="#"><i class="fa fa-user"></i>Profile</a></li>
                                       
                                        <li role="presentation"><a href="#"><i class="fa fa-envelope"></i>Projets<span class="badge badge-success pull-right">4</span></a></li>
                                        <li role="presentation" class="divider"></li>
                                        <li role="presentation"><a href="login"><i class="fa fa-sign-out m-r-xs"></i>Log out</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="login" class="log-out waves-effect waves-button waves-classic">
                                        <span><i class="fa fa-sign-out m-r-xs"></i>Log out</span>
                                    </a>
                                </li>
                            </ul><!-- Nav -->
                        </div><!-- Top Menu -->
                    </div>
                </div>
            </div><!-- Navbar -->
            <div class="page-sidebar sidebar">
                <div class="page-sidebar-inner slimscroll">
                    <div class="sidebar-header">
                        <div class="sidebar-profile">
                            <a href="javascript:void(0);" id="profile-menu-link">
                                <div class="sidebar-profile-image">
                                    <img src="assets/images/avatar1.png" class="img-circle img-responsive" alt="">
                                </div>
                                <div class="sidebar-profile-details">
                                    <span><c:out value = "${user.getNom() }" /><br><small><c:out value = "${user.getFonction() }" /></small></span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <ul class="menu accordion-menu">
                        <li class="active"><a href="index.html" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-home"></span><p>ACCUEIL</p></a></li>
                        <li><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-user"></span><p>PROFILE</p></a></li>

                    </ul>
                </div><!-- Page Sidebar Inner -->
            </div><!-- Page Sidebar -->
            <div class="page-inner">
                <div class="page-title">
                    <h3>Dashboard</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li class="active">Dashboard</li>
                        </ol>
                    </div>
                </div>
                <div id="main-wrapper">
                    <!-- Row -->
                    	
                    	<!--  list of users created by the actual admin -->
                    	
            <div class="col-lg-12 col-md-12">
                <div class="panel panel-white">
                  <div class="panel-heading">
                     <h4 class="panel-title">Liste de vos Utilisateurs</h4>
                                
                   </div>
                  <div class="panel-body">
                  <div class="table-responsive project-stats">
			        <a class="btn btn-success"  id="addUser" href="#">Ajouter un utilisateur</a>
			
			     	<table class="table" id="userList">
					
					<thead>
						<tr>
							
							<th>NOM</th>
							<th>PRENOM</th>
							<th>FONCTION</th>
							<th>STATUT</th>
							<th>Actions</th>
						</tr>
					</thead>

					<tbody>
						<c:if test="${listUser == null }">
							<h2 class="text-center text-info">List vide</h2>
						</c:if>
						<c:forEach var = "userl" items = "${listUser}">
						<tr>
							<td><c:out value = "${userl.getNom() }" /></td>
							<td><c:out value = "${userl.getPrenom() }" /></td>
							<td><c:out value = "${userl.getFonction() }" /></td>
							<td><span class="label label-primary"><c:out value="${userl.isStatut() ? \"Actif\" : \"Non Actif\" }" /></span></td>
							
							<td>
								<a id ="editId" class="btn btn-info btn-ms" data-userId = "<c:out value = "${userl.getId() }" />"
								   data-userFonction = "<c:out value = "${userl.getFonction() }" />" 
								   href="#">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								
								<c:if test="${userl.isStatut() }">
								<a class="btn btn-danger btn-ms" href="desactiver?id=<c:out value = "${userl.getId() }" />&adminId=<c:out value = "${user.getId() }" />">Désactiver</a>
								</c:if>
								<c:if test="${userl.isStatut() == false }">
								<a class="btn btn-warning btn-ms" href="activer?id=<c:out value = "${userl.getId() }" />&adminId=<c:out value = "${user.getId() }" />">Activer</a>
								</c:if>
								
							
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			 </div>
		</div>
	</div>
</div>
                <div class="col-lg-12 col-md-12">
                 <div class="panel panel-white">
                  <div class="panel-heading">
                     <h4 class="panel-title ">Liste de vos projets </h4>
                   </div>
				 </div>
				 
				 <div class="container text-right">
			    	 <a class="btn btn-info"  id="addTache" href="#">Ajouter une Tache</a>
			     </div>
			     
			     <hr>
			     
			     
			    </div>
			    
			  <c:if test="${listProjet == null }">
				<h2 class="text-center text-info">List vide</h2>
			  </c:if>
			  
			  <c:forEach var = "listProjets" items = "${listProjet}">
			  	
             	 <button class="collapsible"><h3 class="panel-title"></h3><c:out value = "${listProjets.getCode_projet() } - ${listProjets.getLib_proj() }" /></button>
					<div class="content2">
						
  					     <div class="col-lg-12 col-md-12">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h5 class="panel-title"><span class="label label-primary" >Detail du Projet  :  </span><c:out value = "${listProjets.getLib_proj() }   -   ${listProjets.getBudget_proj() } - ${listProjets.getType_projet() }" /></h5>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive project-stats">  
                               			
                                       <table class="table" id="tacheAffecterList">
                                           <thead>
                                               <tr>
                                                   <th>Code</th>
                                                   <th>Intitule</th>
                                                   <th>Cout Unitaire</th>
                                                   <th>Avancement</th>
                                                   <th>Status</th>
                                                   <th>Date Debut</th>
                                                   <th>Date Fin</th>
                                                   <th>Manager</th>
                                                   <th>Action</th>
                                               </tr>
                                           </thead>
                                           <tbody>
                                           <h5 class="panel-title">Taches deja affecter(<c:out value = "${listProjets.getListeTachesAffecter().size()  }" />)</h5>
                                            <c:forEach var = "listTache" items = "${listProjets.getListeTachesAffecter()}">
                                               <tr>
                                                   <th scope="row"><c:out value = "${listTache.getCode_tc()  }" /></th>
                                                   <td><c:out value = "${listTache.getDesign_tc()  }" /></td>
                                                   <td><c:out value = "${listTache.getCoutunit_tc()  }" /></td>
                                                   
                                                   
                                                    <c:choose>
												      <c:when test="${listTache.getAvancement() <= 5 }">
												      	<td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:when>
												      
													  <c:when test="${listTache.getAvancement() > 5 && listTache.getAvancement() <= 35 }">
													  <td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:when>
												      <c:when test="${listTache.getAvancement() > 35 && listTache.getAvancement() <= 65 }">
													  <td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:when>
												      <c:when test="${listTache.getAvancement() > 65 && listTache.getAvancement() <= 95 }">
													  <td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:when>
												      
												      <c:otherwise>
												     	<td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:otherwise>
												    </c:choose>
												
												    <c:choose>
												      <c:when test="${listTache.getStatut() == 'En cours'}">
												      	<td><span class="label label-primary"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:when>
												      
													  <c:when test="${listTache.getStatut() == 'Annuler'}">
													  <td><span class="label label-info"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:when>
												      <c:when test="${listTache.getStatut() == 'Terminer'}">
												      <td><span class="label label-success"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:when>
												      <c:when test="${listTache.getStatut() == 'Suspendu'}">
												      	<td><span class="label label-warning"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:when>
												      
												      <c:otherwise>
												     	<td><span class="label label-info"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:otherwise>
												    </c:choose>

                                                   <td><c:out value = "${listTache.getDate_debut()  }" /></td>
                                                   <td><c:out value = "${listTache.getDate_fin()  }" /></td>
                                                   <td><c:out value = "${listTache.getResponsable().getNom()  }" /></td>
                                                   
                                                     <td>
                                                     	
                                                     	<c:choose>
							                              <c:when test="${listTache.getStatut() != 'Annuler' && listTache.getStatut() != 'Terminer'} ">
							                               <a id ="editId" class="label editBtn" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														   data-idTache = "<c:out value = "${listTache.getCode_tc()}"/>"
						                    				data-lib_tc = "<c:out value = "${listTache.getDesign_tc() }"/>"
						                    				data-coutUnitaire = "<c:out value = "${listTache.getCoutunit_tc() }"/>"
						                    				data-dateDebut = "<c:out value = "${listTache.getDate_debut() }"/>"
						                    				data-dateFin= "<c:out value = "${listTache.getDate_fin()}"/>"
						                    				data-avancement = "<c:out value = "${listTache.getAvancement()}"/>"
															href="#"><span class="label label-info">Edit</span></a>
															
							                              </c:when>
                           							     </c:choose>
														
														
														<c:choose>
							                              <c:when test="${listTache.getStatut() == 'Non Debuter' || listTache.getStatut() == 'Suspendu' && listTache.getStatut() != 'Terminer' }">
							                               <a id ="editId" class="label" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														   data-tacheAvancement = "<c:out value = "${ listTache.getAvancement() }" />" 
														   href="demarerTache?code_tc=<c:out value = "${listTache.getCode_tc() }" />&adminId=<c:out value = "${user.getId() }" />"><span class="label label-primary">Demarer</span></a>
														
							                              </c:when>
                           							     </c:choose>
                           							     
                           							     <c:choose>
							                              <c:when test="${listTache.getStatut() != 'Annuler' && listTache.getStatut() != 'Terminer' }">
							                               <a id ="editId" class="label" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														   data-tacheAvancement = "<c:out value = "${ listTache.getAvancement() }" />" 
														   href="retirerTache?code_tc=<c:out value = "${listTache.getCode_tc() }" />&adminId=<c:out value = "${user.getId() }" />&ancienUserId=<c:out value = "${listTache.getResponsable().getId() }" />"><span class="label label-primary">Retirer</span></a>
														
							                              </c:when>
                           							     </c:choose>
                           							     
														<c:choose>
							                              <c:when test="${listTache.getStatut() != 'Suspendu' && listTache.getStatut() != 'Annuler' && listTache.getStatut() != 'Terminer'}">
							                                <a id ="editId" class="label" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														   data-tacheAvancement = "<c:out value = "${listTache.getAvancement() }" />" 
														   href="suspendreTache?code_tc=<c:out value = "${listTache.getCode_tc() }" />&adminId=<c:out value = "${user.getId() }" />"><span class="label label-warning">Suspendre</span></a>
														
							                              </c:when>
                           							     </c:choose>
                           							     
                           							     
														<c:choose>
							                              <c:when test="${listTache.getStatut() != 'Annuler' && listTache.getStatut() != 'Terminer'}">
							                                <a id ="editId" class="label" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														    data-tacheAvancement = "<c:out value = "${listTache.getAvancement() }" />" 
														    href="annulerTache?code_tc=<c:out value = "${listTache.getCode_tc() }" />&adminId=<c:out value = "${user.getId() }" />"><span class="label label-danger">Annuler</span></a>
							                              </c:when>
                           							     </c:choose>
                           							      
														<c:choose>
							                              <c:when test="${listTache.getStatut() != 'Terminer' && listTache.getStatut() != 'Annuler' }">
							                                <a id ="editId" class="label" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														    data-tacheAvancement = "<c:out value = "${listTache.getAvancement() }" />" 
														    href="terminerTache?code_tc=<c:out value = "${listTache.getCode_tc() }" />&adminId=<c:out value = "${user.getId() }" />"><span class="label label-success">Terminer</span></a>
							                              </c:when>
                           							     </c:choose>
													</td>
                                                  
                                               </tr>
                                               
                                               
                                           </tbody>
                                       </c:forEach>           
                                        </table>
                          
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-lg-12 col-md-12">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h5 class="panel-title"><span class="label label-primary" >Detail du Projet  :  </span><c:out value = "${listProjets.getLib_proj() }   -   ${listProjets.getBudget_proj() } - ${listProjets.getType_projet() }" /></h5>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive project-stats">  
                               			
                                       <table class="table" id="tacheNonAffecterList">
                                           <thead>
                                               <tr>
                                                   <th>Code</th>
                                                   <th>Intitule</th>
                                                   <th>Cout Unitaire</th>
                                                   <th>Avancement</th>
                                                   <th>Status</th>
                                                   <th>Date Debut</th>
                                                   <th>Date Fin</th>
                                                   <th>Action</th>
                                               </tr>
                                           </thead>
                                           <tbody>
                                           <h3 class="panel-title">Taches non affecter(<c:out value = "${listProjets.getListeTachesNonAffecter().size()  }" />)</h3>
                                            <c:forEach var = "listTache" items = "${listProjets.getListeTachesNonAffecter()}">
                                               <tr>
                                                   <th scope="row"><c:out value = "${listTache.getCode_tc()  }" /></th>
                                                   <td><c:out value = "${listTache.getDesign_tc()  }" /></td>
                                                   <td><c:out value = "${listTache.getCoutunit_tc()  }" /></td>
                                                   
                                                   
                                                    <c:choose>
												      <c:when test="${listTache.getAvancement() <= 5 }">
												      	<td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:when>
												      
													  <c:when test="${listTache.getAvancement() > 5 && listTache.getAvancement() <= 35 }">
													  <td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:when>
												      <c:when test="${listTache.getAvancement() > 35 && listTache.getAvancement() <= 65 }">
													  <td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:when>
												      <c:when test="${listTache.getAvancement() > 65 && listTache.getAvancement() <= 95 }">
													  <td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:when>
												      
												      <c:otherwise>
												     	<td>
                                                       	  <div class="progress progress-sm">
                                                           <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="<c:out value = "${listTache.getAvancement()  }" />" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value = "${listTache.getAvancement()  }" />%">
                                                           </div>
                                                          </div>
	                                                   </td>
												      </c:otherwise>
												    </c:choose>
												
												    <c:choose>
												      <c:when test="${listTache.getStatut() == 'En cours'}">
												      	<td><span class="label label-primary"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:when>
												      
													  <c:when test="${listTache.getStatut() == 'Annuler'}">
													  <td><span class="label label-info"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:when>
												      <c:when test="${listTache.getStatut() == 'Terminer'}">
												      <td><span class="label label-success"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:when>
												      <c:when test="${listTache.getStatut() == 'Suspendu'}">
												      	<td><span class="label label-warning"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:when>
												      
												      <c:otherwise>
												     	<td><span class="label label-info"><c:out value = " ${listTache.getStatut()  }" /></span></td>
												      </c:otherwise>
												    </c:choose>

                                                   <td><c:out value = "${listTache.getDate_debut()  }" /></td>
                                                   <td><c:out value = "${listTache.getDate_fin()  }" /></td>
                                                   
													<td>
														<c:choose>
							                              <c:when test="${listTache.getStatut() != 'Annuler'}">
							                               <a id ="editId" class="label editTacheNonAffecter" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														   data-idTache = "<c:out value = "${listTache.getCode_tc()}"/>"
						                    				data-lib_tc = "<c:out value = "${listTache.getDesign_tc() }"/>"
						                    				data-coutUnitaire = "<c:out value = "${listTache.getCoutunit_tc() }"/>"
						                    				data-dateDebut = "<c:out value = "${listTache.getDate_debut() }"/>"
						                    				data-dateFin= "<c:out value = "${listTache.getDate_fin()}"/>"
						                    				data-avancement = "<c:out value = "${listTache.getAvancement()}"/>"
															href="#"><span class="label label-info">Edit</span></a>
															
							                              </c:when>
                           							     </c:choose>
														
														<c:choose>
							                              <c:when test="${listTache.getStatut() != 'Annuler'}">
							                               <a id ="affecterId" class="label affecterBtn" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														   data-code_tc = "<c:out value = "${listTache.getCode_tc() }" />" 
														   data-ancienResponsableId = "<c:out value = "${listTache.getResponsable().getId() }" />" 
														   href="#"><span class="label label-primary">Affecter</span></a>
														
							                              </c:when>
                           							     </c:choose>
														
														<c:choose>
							                              <c:when test="${listTache.getStatut() != 'Suspendu' && listTache.getStatut() != 'Annuler'}">
							                                <a id ="editId" class="label" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														   data-tacheAvancement = "<c:out value = "$listTache.getAvancement() }" />" 
														   href="suspendreTache?code_tc=<c:out value = "${listTache.getCode_tc() }" />&adminId=<c:out value = "${user.getId() }" />"><span class="label label-warning">Suspendre</span></a>
														
							                              </c:when>
                           							     </c:choose>
                           							     
                           							     
														<c:choose>
							                              <c:when test="${listTache.getStatut() != 'Annuler'}">
							                                <a id ="editId" class="label" data-userId = "<c:out value = "${listTache.getCode_tc() }" />"
														    data-tacheAvancement = "<c:out value = "${listTache.getAvancement() }" />" 
														    href="annulerTache?code_tc=<c:out value = "${listTache.getCode_tc() }" />&adminId=<c:out value = "${user.getId() }" />"><span class="label label-danger">Annuler</span></a>
							                              </c:when>
                           							     </c:choose>
														
													</td>													
                                                  
                                               </tr>
                                               
                                               
                                           </tbody>
                                       </c:forEach>           
                                        </table>
                          
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                      </c:forEach>
                    </div>
                    
                    <hr>
                    <!-- Deuxième tableau -->
                    
                    
                    
                    
                    
                                
                    
                    <!-- Fin contenu collapsible -->
				</div>

                    	<!--  end of the list -->
                    
                    
                    
                </div><!-- Main Wrapper -->
                <div class="page-footer">
                    <p class="no-s">2019 &copy; Groupe 8 ING 2 DESIGN.</p>
                </div>
            </div><!-- Page Inner -->
        </main><!-- Page Content -->
        <nav class="cd-nav-container" id="cd-nav">
            <header>
                <h3>Navigation</h3>
                <a href="#0" class="cd-close-nav">Close</a>
            </header>
            <ul class="cd-nav list-unstyled">
                <li class="cd-selected" data-menu="index">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-home"></i>
                        </span>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li data-menu="profile">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-user"></i>
                        </span>
                        <p>Profile</p>
                    </a>
                </li>
                <li data-menu="inbox">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-envelope"></i>
                        </span>
                        <p>Mailbox</p>
                    </a>
                </li>
                <li data-menu="#">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-tasks"></i>
                        </span>
                        <p>Tasks</p>
                    </a>
                </li>
                <li data-menu="#">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-cog"></i>
                        </span>
                        <p>Settings</p>
                    </a>
                </li>
                <li data-menu="calendar">
                    <a href="javsacript:void(0);">
                        <span>
                            <i class="glyphicon glyphicon-calendar"></i>
                        </span>
                        <p>Calendar</p>
                    </a>
                </li>
            </ul>
        </nav>
        <div class="cd-overlay"></div>
		
			<div class="w3-container">

  <div id="editModal" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('editModal').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <img src="images/img_avatar4.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>

      <form id="userForm" class="w3-container" action="update" method="post">
        <div class="w3-section">
				<input type="hidden" id="hiddenAdminId" name="idAdmin" value="<c:out value = "${user.getId() }" />" />
				<input type="hidden" id="hiddenId" name="id" value="" />
		  
		  
		  <label class = "lab"><b>Nom : </b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" id="nom" name="nom" required>
          <label class = "lab"><b>Prenom </b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" id="prenom" name="prenom" required>
          <label><b>Fonction</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" id="fonction" name="fonction" required>
          <label class="lab"><b>Login</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" id="login" name="login" required>
          <label class="lab"><b>Password</b></label>
          <input class="w3-input w3-border" type="text" placeholder="Enter Password" id="pwd" name="pwd" required>
		
          <input class="w3-buttons w3-block w3-green w3-section w3-padding" type="submit" value="Confirm"/>
        </div>
      </form>
    </div>
  </div>
  
  
  <!--  Modal pour les operations sur les taches -->
  	
  	
  <div id="editModalTache" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('editModalTache').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <img src="images/tache.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>

      <form id="tacheForm" class="w3-container" action="updateTache" method="post">
        <div class="w3-section">
				<input type="hidden" id="hiddenAdminId" name="idAdmin" value="<c:out value = "${user.getId() }" />" />
				<input type="hidden" id="hiddenId" name="id" value="" />
				<input type="hidden" id="hiddenCode" name="code" value="" />
		  
		  
		  <label class = "lab affecter"><b>Code : </b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter task code" id="code_tc" name="code_tc" required>
          <label class="affecter"><b>Intitule </b></label>
          <input class="w3-input w3-border w3-margin-bottom affecter" type="text" placeholder="Enter task name" id="design_tc" name="design_tc" required>
          <label class="affecter"><b>Cout Unitaire</b></label>
          <input class="w3-input w3-border w3-margin-bottom affecter" type="number"  placeholder="Enter unit cost" id="prixUnitaire" name="prixUnitaire" required>
          <label class="affecter"><b>Avancement</b></label>
          
          <input class="w3-input w3-border w3-margin-bottom affecter" type="number" min= "0" max="100" placeholder="Enter progress value" id="avancement" name="avancement" required>
          <label class="affecter"><b>Selectionner le projet</b></label>
          <select class="w3-input w3-border w3-margin-bottom affecter" name="codeProjet">
        	<c:forEach var = "listProjets" items = "${listProjet}">
            <option value="<c:out value = "${listProjets.getCode_projet()}" />"><c:out value = "${listProjets.getLib_proj()}" /></option>
        	</c:forEach>
    	  </select>
    	  
    	  <label><b>Selectionner le Responsable</b></label>
    	  
          <select class="w3-input w3-border w3-margin-bottom" name="codeResponsable">
          	<option selected="selected" value = "0">Aucun pour le moment</option>
        	<c:forEach var = "user" items = "${listUser}">
            <option value="<c:out value = "${user.getId()}" />"><c:out value = "${user.getNom()}" /></option>
        	</c:forEach>
    	  </select>
    	  <div class="w3-container statut affecter w3-margin-top">
			<label><b>Statut</b></label>
			<select class="w3-select w3-border w3-round-large" name="statut" id="statut">
				<option value="" disabled selected>Statut du projet</option>
				<option value="En cours">En cours</option>
				<option value="Annuler">Annuler</option>
				<option value="Terminer">Terminer</option>
				<option value="Suspendu">Suspendu</option>
			</select>
		 </div>
          <label class="lab affecter">Date debut<b></b></label>
          <input class="w3-input w3-border affecter" type="date" placeholder="Enter begin date" id="dateDebut" name="dateDebut" required>
          
          <label class="affecter">Date Fin<b></b></label>
          <input class="w3-input w3-border affecter" type="date" placeholder="Enter end date" id="dateFin" name="dateFin" required>
          
		
          <input class="w3-buttons w3-block w3-teal w3-section w3-padding " type="submit" value="Confirm"/>
        </div>
      </form>
    </div>
  </div>
  <!--  Fin Modal des taches -->
</div>  

        <!-- Javascripts -->
        
       
        
        <script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-2.1.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/jquery-ui/jquery-ui.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/pace-master/pace.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/jquery-blockui/jquery.blockui.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/switchery/switchery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/uniform/jquery.uniform.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/offcanvasmenueffects/js/classie.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/offcanvasmenueffects/js/main.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/waves/waves.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/3d-bold-navigation/js/main.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/waypoints/jquery.waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/jquery-counterup/jquery.counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/toastr/toastr.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/flot/jquery.flot.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/flot/jquery.flot.time.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/flot/jquery.flot.symbol.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/flot/jquery.flot.resize.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/flot/jquery.flot.tooltip.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/curvedlines/curvedLines.js"></script>
        <script src="${pageContext.request.contextPath}/assets/plugins/metrojs/MetroJs.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/modern.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/pages/dashboard.js"></script>
        
        
        
        <!--  Prise en compte des collapsible -->
        
        	
			<script>
			var coll = document.getElementsByClassName("collapsible");
			var i;
			
			for (i = 0; i < coll.length; i++) {
			  coll[i].addEventListener("click", function() {
			    this.classList.toggle("active");
			    var content = this.nextElementSibling;
			    if (content.style.maxHeight){
			      content.style.maxHeight = null;
			    } else {
			      content.style.maxHeight = content.scrollHeight + "px";
			    } 
			  });
			}
</script>
        
        <!-- Fin collapsible -->
        
        
        <!--  prise en compte des modals -->
        
       

	<script type="text/javascript">
	$('#userList').on('click', '.btn-info', function() {
		
		document.getElementById('editModal').style.display='block';
		
		
		var userId = $(this).attr('data-userId');
		document.getElementById('login').remove();
		document.getElementById('pwd').remove();
		document.getElementById('prenom').remove();
		document.getElementById('nom').remove();
		
		$("label.lab").hide(); // Lorsqu'on veut editer un utilisateur, on cache tous les autres champs sauf celui de fonction
		
		//var userId = $(this).attr('data-userId');
		var userFonction = $(this).attr('data-userFonction');
		
		$('#hiddenId').val(userId);
		$('#fonction').val(userFonction);
		
		
	});

	$('#addUser').on('click', function() {
	
		document.getElementById('editModal').style.display='block';
		
		document.getElementById("userForm").action = "insertUser";
		
		document.getElementById('login').style.display = "block";
		document.getElementById('pwd').style.display = "block";
		document.getElementById('prenom').style.display = "block";
		document.getElementById('nom').style.display = "block";
		
		$("label.lab").show();
	});
	</script>
	
	<!-- Fin prise en compte des modals utilisateur -->
	
	<!-- Prise en compte modal des taches -->
	
	<script type="text/javascript">
	
$('#tacheNonAffecterList').on('click', '.editTacheNonAffecter', function() {
		
		document.getElementById('editModalTache').style.display='block';
		
		var code_tache = $(this).attr('data-idTache');
		var lib_tache = $(this).attr('data-lib_tc');
		var coutUnitaire = $(this).attr('data-coutUnitaire');
		//var userId = $(this).attr('data-userId');
		
		
		$('#design_tc').val(lib_tache);
		$('#prixUnitaire').val(coutUnitaire);
		$("label.lab").hide(); // Lorsqu'on veut editer un utilisateur, on cache tous les autres champs sauf celui de fonction
		
		var userId = $(this).attr('data-userId');
		
		
		$('#hiddenId').val(userId);
		$('#hiddenCode').val(code_tache);
		$(".statut").show();
		$(".affecter").show();
		
		
		document.getElementById('code_tc').remove();
		document.getElementById('dateDebut').remove();
		
	});
	
$('#tacheNonAffecterList').on('click', '.affecterBtn', function() {

	
	document.getElementById('editModalTache').style.display='block';
	
	document.getElementById("tacheForm").action = "affecterTache";
	
	
	var code_tache = $(this).attr('data-code_tc');
	
	
	$('#hiddenCode').val(code_tache);
	
	
	document.getElementById('code_tc').remove();
	document.getElementById('dateDebut').remove();
	document.getElementById('dateFin').remove();
	document.getElementById('design_tc').remove();
	document.getElementById('prixUnitaire').remove();
	document.getElementById('avancement').remove();
	
	
	$(".affecter").hide();
	$(".statut").hide();
	
	
	//$(".lab").hide(); // Lorsqu'on veut editer un utilisateur, on cache tous les autres champs sauf celui de fonction
	
	
});

	
$('#tacheAffecterList').on('click', '.editBtn', function() {
		
	document.getElementById('editModalTache').style.display='block';
	
	var code_tache = $(this).attr('data-idTache');
	var lib_tache = $(this).attr('data-lib_tc');
	var coutUnitaire = $(this).attr('data-coutUnitaire');
	var userId = $(this).attr('data-userId');
	
	
	$('#design_tc').val(lib_tache);
	$('#prixUnitaire').val(coutUnitaire);
	$("label.lab").hide(); // Lorsqu'on veut editer un utilisateur, on cache tous les autres champs sauf celui de fonction

	//var userId = $(this).attr('data-userId');
	
	
	$('#hiddenId').val(userId);
	$('#hiddenCode').val(code_tache);
	$(".statut").show();
	$(".affecter").show();
	
	
	document.getElementById('code_tc').remove();
	document.getElementById('dateDebut').remove();
		
		
	});

	$('#addTache').on('click', function() {
	
		document.getElementById('editModalTache').style.display='block';
		
		document.getElementById("tacheForm").action = "insertTache";
		
		
		
// 		$("label.lab").show();
		
// 		$(".affecter").show();
		$(".statut").hide();
		

		$('#code_tc').val("");
		$('#design_tc').val("");
		$('#prixUnitaire').val("");
		$('#avancement').val("");
		
		document.getElementById('ancien_responsable').remove();
		
		
		$(".ancienUser").hide();
	});
	
	
	</script>
	
	<!-- Fin prise en compte des modals utilisateur -->
	
    </body>

<!-- Mirrored from lambdathemes.in/modern/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 24 Apr 2015 11:03:35 GMT -->
</html></html>