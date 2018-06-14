// Exported from:        http://44c9647b4ea2:5516/#/templates/Folder73b081e48ae84e3aa5a539f292e610d0-Folder48d52b1f64ae4c2ea7597d1be829e1dd-Release5ca1824725374764ae57a98ce7cf540b/releasefile
// XL Release version:   8.1.0-rc.3
// Date created:         Thu Jun 14 12:40:38 UTC 2018

def server(type, title, folderPath = null) {
    def folderId = null
    if(folderPath) {
          folderId = folderApi.find(folderPath, 0).getId()
    }
    def cis = configurationApi.searchByTypeAndTitle(type, title, folderId)
    if (cis.isEmpty()) {
        throw new RuntimeException("No CI found for the type '${type}' and title '${title}'")
    }
    if (cis.size() > 1) {
        throw new RuntimeException("More than one CI found for the type '${type}' and title '${title}'")
    }
    cis.get(0)
}

def jumpstation1 = server('remoteScript.SshJumpstation','Jum station 2','f1')
def jumpstation2 = server('remoteScript.SshJumpstation','JUmp Station 1','f1')
def jumpstation3 = server('remoteScript.SshJumpstation','JUmp Station 1','f1')

xlr {
  template('templae1') {
    folder('f1/f2')
    scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2018-06-14T07:00:00+0000')
    phases {
      phase('New Phase') {
        color '#FD8D10'
        tasks {
          custom('sdg') {
            script {
              type 'remoteScript.WindowsSsh'
              jumpstation jumpstation1
            }
          }
          custom('Jenkins') {
            script {
              type 'jenkins.Build'
              
            }
          }
          custom('asfd') {
            script {
              type 'remoteScript.Windows'
              jumpstation jumpstation2
            }
          }
          custom('se') {
            script {
              type 'remoteScript.Windows'
              
            }
          }
          manual('asdgf') {
            
          }
          custom('asf') {
            script {
              type 'remoteScript.Windows'
              remotePath 'dSD'
              jumpstation jumpstation3
              address 'sfdhbz'
            }
          }
        }
      }
      phase('New Phase') {
        color '#999999'
        tasks {
          manual('T1') {
            
          }
          manual('T2') {
            
          }
          manual('adfs') {
            
          }
        }
      }
    }
    
  }
}