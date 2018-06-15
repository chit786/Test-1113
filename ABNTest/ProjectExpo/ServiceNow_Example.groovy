// Exported from:        http://Chitrangs-MacBook-Pro.local:5516/#/templates/Folder4f8585fe531f4f3d8cf7be851a233a34-Releaseff3c83bde9ef44b6824580e9ecb556c0/releasefile
// XL Release version:   8.1.0-SNAPSHOT
// Date created:         Fri Jun 15 08:21:46 CEST 2018

xlr {
  template('ServiceNow_Example') {
    folder('Folder 1')
    variables {
      stringVariable('short_description') {
        
      }
      stringVariable('comment') {
        
      }
      stringVariable('ChangeTicket') {
        required false
        showOnReleaseStart false
      }
      stringVariable('taskId') {
        required false
        showOnReleaseStart false
      }
      stringVariable('TaskNumber') {
        required false
        showOnReleaseStart false
      }
      stringVariable('ChangeTask') {
        required false
        showOnReleaseStart false
      }
      stringVariable('ChangeTicke') {
        required false
        showOnReleaseStart false
      }
      stringVariable('sysId') {
        required false
        showOnReleaseStart false
      }
      stringVariable('sysId2') {
        required false
        showOnReleaseStart false
      }
      stringVariable('ChangeTicket2') {
        required false
        showOnReleaseStart false
      }
    }
    scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2016-04-02T15:00:00+0200')
    phases {
      phase('Create Change') {
        color '#68b749'
        tasks {
          manual('Create Change Ticket') {
            flagStatus com.xebialabs.xlrelease.domain.status.FlagStatus.ATTENTION_NEEDED
            flagComment 'Task \'Create Change Ticket\' in Phase \'Create Change\' has been replaced by a manual task. The task of type \'servicenow.CreateChangeRequest\' could not be found because of a missing plugin.'
          }
          manual('Create Task on ${ChangeTicket}') {
            flagStatus com.xebialabs.xlrelease.domain.status.FlagStatus.ATTENTION_NEEDED
            flagComment 'Task \'Create Task on ${ChangeTicket}\' in Phase \'Create Change\' has been replaced by a manual task. The task of type \'servicenow.CreateTask\' could not be found because of a missing plugin.'
          }
          gate('Verify ${ChangeTicket} & ${TaskNumber}') {
            conditions {
              condition('${ChangeTicket}')
              condition('${TaskNumber}')
            }
          }
          manual('Check for approval on ${ChangeTicket}') {
            flagStatus com.xebialabs.xlrelease.domain.status.FlagStatus.ATTENTION_NEEDED
            flagComment 'Task \'Check for approval on ${ChangeTicket}\' in Phase \'Create Change\' has been replaced by a manual task. The task of type \'servicenow.PollingCheckStatus\' could not be found because of a missing plugin.'
          }
          manual('Test') {
            
          }
        }
      }
      phase('Process Change') {
        color '#009CDB'
        tasks {
          manual('Close Task ${TaskNumber}') {
            flagStatus com.xebialabs.xlrelease.domain.status.FlagStatus.ATTENTION_NEEDED
            flagComment 'Task \'Close Task ${TaskNumber}\' in Phase \'Process Change\' has been replaced by a manual task. The task of type \'servicenow.UpdateTask\' could not be found because of a missing plugin.'
          }
          script('Deploy Application from Custom Script') {
            script 'print "#Executing Deployment Script#\\n"\n' +
                   'print "**DONE**\\n"'
          }
          manual('Close Change ${ChangeTicket}') {
            flagStatus com.xebialabs.xlrelease.domain.status.FlagStatus.ATTENTION_NEEDED
            flagComment 'Task \'Close Change ${ChangeTicket}\' in Phase \'Process Change\' has been replaced by a manual task. The task of type \'servicenow.UpdateChangeRequest\' could not be found because of a missing plugin.'
          }
          gate('Verify ${ChangeTicket} & ${TaskNumber}') {
            conditions {
              condition('${ChangeTicket}')
              condition('${TaskNumber}')
            }
          }
        }
      }
      phase('Create Another Change') {
        color '#ff9e3b'
        tasks {
          manual('Request Approval') {
            flagStatus com.xebialabs.xlrelease.domain.status.FlagStatus.ATTENTION_NEEDED
            flagComment 'Task \'Request Approval\' in Phase \'Create Another Change\' has been replaced by a manual task. The task of type \'servicenow.RequestApproval\' could not be found because of a missing plugin.'
          }
          manual('Update Change Request ${ChangeTicket2}') {
            flagStatus com.xebialabs.xlrelease.domain.status.FlagStatus.ATTENTION_NEEDED
            flagComment 'Task \'Update Change Request ${ChangeTicket2}\' in Phase \'Create Another Change\' has been replaced by a manual task. The task of type \'servicenow.UpdateChangeRequest\' could not be found because of a missing plugin.'
          }
          gate('Verify ${ChangeTicket2}') {
            conditions {
              condition('${ChangeTicket2}')
            }
          }
        }
      }
      phase('Post Release Update CMDB') {
        color '#009CDB'
        tasks {
          manual('CMDB Update') {
            flagStatus com.xebialabs.xlrelease.domain.status.FlagStatus.ATTENTION_NEEDED
            flagComment 'Task \'CMDB Update\' in Phase \'Post Release Update CMDB\' has been replaced by a manual task. The task of type \'servicenow.UpdateCMDB\' could not be found because of a missing plugin.'
          }
        }
      }
    }
    
  }
}