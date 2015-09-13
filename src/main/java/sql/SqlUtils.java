package sql;

/**
 * Created by Ray on 2015/9/13.
 * SQL��䴦������
 */
public class SqlUtils {

    /**
     * ʵ��Javaռλ������sql��䣬������sql��������ӱ���
     * @param sql ����ռλ��(?)��sql���
     * @param args ռλ����Ӧ�ı������ɱ����
     * @return ���Ӻ��sql���
     * @throws Exception
     */
    public static String get(String sql, String... args) throws Exception {
        // sqlǰ��ӿո��Ŀ���ǣ���ʹռλ��?���ַ������ˣ�Ҳ�ܱ�֤�ָ��(?������+1)��
        StringBuffer sb = new StringBuffer(" ");
        sql = sb.append(sql).append(" ").toString();
        String[] sqlarr = sql.split("\\?");
        // check
        if (sqlarr.length  - args.length != 1) {
            throw new Exception("ռλ�������������һ�£�");
        }

        sb = new StringBuffer(sqlarr[0]);

        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]).append(sqlarr[i+1]);
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws Exception {
        String sql = SqlUtils.get("select * from coreusercard where userno = '?' and znkh = '?'", "12138", "3333333333333");
        System.out.println(sql);
    }

}
