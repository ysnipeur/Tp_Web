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
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown"><i class="fa fa-bell"></i><span class="badge badge-success pull-right"><c:out value = "${listTache.size() } " /></span></a>
                                    <ul class="dropdown-menu title-caret dropdown-lg" role="menu">
                                        <li><p class="drop-title">You have <c:out value = "${listTache.size() } " /> pending tasks !</p></li>
                                        <li class="dropdown-menu-list slimscroll tasks">
                                            <ul class="list-unstyled">
                                            <c:forEach var = "listTache" items = "${listTache}">
                                                <li>
                                                    <a href="#">
                                                        <div class="task-icon badge badge-success"><i class="icon-energy"></i></div>
                                                        <span class="badge badge-roundless badge-default pull-right"><c:out value = "${listTache.getCoutunit_tc() } " /></span>
                                                        <p class="task-details"><c:out value = "${listTache.getDesign_tc() } " /></p>
                                                    </a>
                                                </li>
                                             </c:forEach>:
                                              
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
                                        <li role="presentation"><a href="profile.html"><i class="fa fa-user"></i>Profile</a></li>
                                        <li role="presentation"><a href="inbox.html"><i class="fa fa-envelope"></i>Taches<span class="badge badge-success pull-right"><c:out value = "${listTache.size() } " /></span></a></li>
                                        <li role="presentation" class="divider"></li>
                                        <li role="presentation"><a href=" "><i class="fa fa-sign-out m-r-xs"></i>Log out</a></li>
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
                        <li class="active"><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-home"></span><p>ACCUEIL</p></a></li>
                        <li ><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-user"></span><p>PROFILE</p></a></li>
                        
                        
                        
                        
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
                    <div class="row">
                    	
                        <div class="col-lg-3 col-md-6">
                        <a href="cvKOUEMOU" target="blanck">
                            <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p></p>
                                        <span class="info-box-title">CV KOUEMOU MODI SAMANTA</span>
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-eye"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                             </a>
                        </div>
                       
                        
                        <div class="col-lg-3 col-md-6">
                        <a href="cvYvan" target="blanck">
                            <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p></p>
                                        <span class="info-box-title">CV TAKOUMBO MBE YVAN</span>
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-eye"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </a>
                        </div>
                        
                        
                       
                        <div class="col-lg-3 col-md-6">
                         <a href="cvMOUTEKE" target="blanck">
                            <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p><span ></span></p>
                                        <span class="info-box-title">CV DESTIN MOUTEKE</span>
                                    </div>
                                    <div class="info-box-icon">
                                        <i class="icon-eye"></i>
                                    </div>
                                    <div class="info-box-progress">
                                        <div class="progress progress-xs progress-squared bs-n">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </a>
                        </div>
                        
                        
                      
                    </div><!-- Row -->
			    
             	 <button class="collapsible"><h3 class="panel-title">LISTE DE VOS TACHES (CLIQUER POUR DEROULER)</button>
					<div class="content2">
						
  					     <div class="col-lg-12 col-md-12">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h5 class="panel-title"><span class="label label-primary" >Detail des Taches</span></h5>
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
                                                   
                                               </tr>
                                           </thead>
                                           <tbody>
                                           <h5 class="panel-title">Nombre total(<c:out value = "${listTache.size()  }" />)</h5>
                                            <c:forEach var = "listTache" items = "${listTache}">
                                            
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

                                               
                                               
                                           </tbody>
                                       </c:forEach>           
                                        </table>
                          
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        
                    </div>
                    </div>
                    
                    <hr>
                    <!-- Deuxième  fin -->
                    
                    
                    
                    
                    
                    
                    
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
        
       
    </body>

</html></html>