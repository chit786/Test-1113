// Exported from:        https://Chitrangs-MBP.xebialabs.com:5516/xlr/#/templates/Folder21d097475e154858aef8d346c8736245-Releaseab784a32201f4149a88180f2086c2269/releasefile
// XL Release version:   8.2.0-SNAPSHOT
// Date created:         Thu Aug 30 14:59:38 CEST 2018

xlr {
  template('Test1') {
    folder('TEstnow')
    scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2018-08-30T09:00:00+0200')
    phases {
      phase('New Phase') {
        color '#999999'
        tasks {
          manual('T1') {
            comments {
              comment {
                text 'ckmmen1'
                author 'admin'
                date Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2018-08-30T14:36:21+0200')
              }
            }
          }
        }
      }
      phase('New Phase') {
        color '#999999'
        tasks {
          manual('T1') {
            
          }
        }
      }
      phase('New Phase') {
        tasks {
          manual('T1') {
            
          }
        }
      }
      phase('New Phase') {
        tasks {
          manual('T1') {
            
          }
        }
      }
    }
    
  }
}