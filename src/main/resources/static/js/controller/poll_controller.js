'use strict';

angular.module('myApp').controller('PollController',
		[ '$scope', 'PollService', function($scope, PollService) {
			var self = this;
//			self.poll = {				title : ''			};
			self.user={"name":"Emanuel","email":"emanuel@gmail.com"}
			self.option={"description":null,"votes":null,"creator":null}
			self.poll = [];
			self.submit = submit;

			fetchPoll();

			function fetchPoll() {
				PollService.getPoll().then(function(d) {
					self.poll = d;
				}, function(errResponse) {
					console.error('Error while fetching poll');
				});
			}
			function submit() {
				//      if(self.poll.id!==null){
				addOption(self.poll.id, self.newOption, 'test');
				//      }else{
				//          updateUser(self.user, self.user.id);
				//          console.log('User updated with id ', self.user.id);
				//      }
//				reset();
			}
			function addOption(poll, newoption, username) {
				console.log(self.option);
				self.user.name=username;
				self.option.description=newoption;
				self.option.user=self.user;
				self.option.id=1; //TODO
				
				PollService.addOption(self.option);
				self.poll.options.push(self.option);
				
				reset();
			}
			function reset(){
				self.option={"description":null,"votes":null,"creator":null};
				$scope.addOption.$setPristine();
			}
		} ]);