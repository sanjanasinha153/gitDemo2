sap.ui.define(
	["sap/ui/core/mvc/Controller",
	 "jquery.sap.global",
	 "testing/utility/services",
	 "sap/m/MessageBox"
	 ],
	function(Controller,jQuery,serv,MessageBox){
		return Controller.extend("testing.controller.Main",{
			onInit:function(){
				//create a model
				var oModel = new sap.ui.model.json.JSONModel();
				//assign data to model
				oModel.setData({
					"postPayload":{
					"companyName":"",
					"contactName":"",
					"lastName"	 :"",
					"firstName"	 :"",
					"website"	 :"",
					"email"		 :"",
					"status"	 :"",
					"regDate"	 :""
					},
					"vendor": {}
				});
				sap.ui.getCore().setModel(oModel);
			},
			
			onSave: function() {
				var oModl = sap.ui.getCore().getModel();
				var payload = oModl.getProperty("/postPayload");
				serv.callServices("/vendor","POST",payload).then(function(){
					MessageBox.confirm("saved successful");
				}).
				catch(function(){
					MessageBox.error("post failed");
				});
			},
			
			onEdit: function() {
				
			},
			
			onLoadData:function() {
				var that = this;
				serv.callServices("/newVendor","GET",{}).then(function(data){
					//call table id 
					var oTab = that.getView().byId("idTable");
					//get model to the view
					var oMod = sap.ui.getCore().getModel();
					oMod.setProperty("/vendor", data._embedded.test);
					//bind table and model
					oTab.bindRows("/vendor");
				}).
				catch(function(){});
					
			}
		});
});